/*
https://leetcode.com/problems/print-zero-even-odd/
 */
package demos.threading;

import java.util.function.IntConsumer;

public class ZeroEvenOddSemaphore {
    private final SemaphoreTest zero = new SemaphoreTest(1);
    private final SemaphoreTest even = new SemaphoreTest(0);
    private final SemaphoreTest odd = new SemaphoreTest(0);
    final int n;

    public static void main(String[] args) {
        int n = 5;
        IntConsumer printNumber = i->System.out.print(i);
        ZeroEvenOddSemaphore zeroEvenOdd = new ZeroEvenOddSemaphore(n);
        new Thread(()-> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
    public ZeroEvenOddSemaphore(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) odd.release();
            else even.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}