/*
https://leetcode.com/problems/print-in-order/

 */
package demos.threading;

class PrintInOrder {
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);
    Semaphore s3 = new Semaphore(0);

    public PrintInOrder() {

    }

    public static void main(String[] args) throws InterruptedException {
        PrintInOrder printInOrder = new PrintInOrder();
        new Thread(()-> {
            try {
                printInOrder.second(()->System.out.print("second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                printInOrder.third(()->System.out.print("third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                printInOrder.first(()->System.out.print("first"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        s1.acquire();
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        s2.acquire();
        printSecond.run();
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        s3.acquire();
        printThird.run();

    }
}