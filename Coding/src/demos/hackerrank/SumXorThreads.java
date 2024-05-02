/*
Given an integer , find each  such that:
x<=x<=n
n+x = x xor n
where  denotes the bitwise XOR operator. Return the number
 */

package demos.hackerrank;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumXorThreads {
    public static long sumXor(long n) throws Exception {
        // Write your code here
        int threads = 64;
        if ( n<1000) threads = 1;
        Future<Long>[] futures = new Future[threads];
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        for (int i=0;i<threads;i++) {
            futures[i] = executorService.submit(new SumXorTask(n, i, threads));
        }

        long count = 0L;
        for (int i=0;i<threads;i++) {
            count += futures[i].get();
        }
        executorService.shutdown();
        return count;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(sumXor(5));
    }
}

class SumXorTask implements Callable<Long> {
    long n;
    int order, threads;

    public SumXorTask(long n, int order, int threads) {
        this.n = n;
        this.order = order;
        this.threads = threads;
    }
    @Override
    public Long call() {
        System.out.printf("%d ...\n", order);
        Long count = 0L;
        for (long i=order;i<=n;i = i+threads) {
            if ((n + i) == (n ^ i)) count++;
            System.out.printf("%d,%d,%d ...\n", order, i, count);
        }
        return count;
    }

}
