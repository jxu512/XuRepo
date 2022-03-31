/*
https://leetcode.com/problems/print-zero-even-odd/
*/
package demos.threading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    CyclicBarrier[] barrier = new CyclicBarrier[3];
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        barrier[0] = new CyclicBarrier(2);
        barrier[1] = new CyclicBarrier(2);
        barrier[2] = new CyclicBarrier(2);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++) {
            try{
                if(i>0) 
                    barrier[2].await();
                printNumber.accept(0);
                barrier[0].await();
            }
            catch(BrokenBarrierException e) {}
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++) {
            try{
                barrier[1].await();
                if(i%2==0) printNumber.accept(i);
                if(i<n) barrier[2].await();
            }
            catch(BrokenBarrierException e) {}
        }
        
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++) {
            try{
                barrier[0].await();
                if(i%2==1) printNumber.accept(i);
                barrier[1].await();
            }
            catch(BrokenBarrierException e) {}
        }
        
    }
}