package demos.threading;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;
    volatile private int count = 1;

    Semaphore sNumber = new Semaphore(1);
    Semaphore sFizz = new Semaphore(0);
    Semaphore sBuzz = new Semaphore(0);
    Semaphore sFizzBuzz = new Semaphore(0);

    public static void main(String[] args) {
        int n = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(n);

        new Thread(()-> {
            try {
                fizzBuzz.fizz(()->System.out.print("fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                fizzBuzz.buzz(()->System.out.print("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                fizzBuzz.fizzbuzz(()->System.out.print("fizzbuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                fizzBuzz.number(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true) {
            while (sFizz.availablePermits() == 0) {
                //System.out.println("wait for sFizz");
                if (count >= n) return;
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            sFizz.acquire();
            printFizz.run();
            nextSemaphore();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true) {
            while (sBuzz.availablePermits() == 0) {
                //System.out.println("wait for sBuzz");
                if (count >= n) return;
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            sBuzz.acquire();
            printBuzz.run();
            nextSemaphore();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true) {
            while (sFizzBuzz.availablePermits() == 0) {
                //System.out.println("wait for sFizzBuzz");
                if (count >= n) return;
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            sFizzBuzz.acquire();
            printFizzBuzz.run();
            nextSemaphore();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

        while(true) {
            while (sNumber.availablePermits() == 0) {
                //System.out.println("wait for sNumber");
                if (count >= n) return;
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            //System.out.println("Acquiring sNumber");
            sNumber.acquire();
            //System.out.println("Acquired sNumber");
            printNumber.accept(count);
            //System.out.println(count);
            nextSemaphore();
        }
    }

    private void nextSemaphore() {
        //System.out.println("in nextSemaphore: " + count);
        if (count >= n) return;
        count++;
        //System.out.println("next: " + count);
        if (count%3 == 0  && count%5 == 0) sFizzBuzz.release();
        else if (count%3==0) sFizz.release();
        else if (count%5==0) sBuzz.release();
        else sNumber.release();
    }
}
