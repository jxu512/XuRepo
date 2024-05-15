package demos.companies.ubs;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SequenceFromThreads {

    AtomicInteger seqAtomic;
    int[] seqInt;
    int threads = 4;
    CyclicBarrier[] cyclicBarriers;

    public SequenceFromThreads() {
        seqAtomic = new AtomicInteger();
        seqInt = new int[1];
        cyclicBarriers = new CyclicBarrier[threads];
    }

    public static void main(String[] args) throws InterruptedException {
        SequenceFromThreads sequenceFromThreads = new SequenceFromThreads();

        System.out.println("With Callable and atomic");
        sequenceFromThreads.processWCallableAtomic();

        System.out.println("\nWith Runnable and atomic");
        sequenceFromThreads.processWRunnableAtomic();

        System.out.println("\nWith Callable and array");
        sequenceFromThreads.processWCallable();

        System.out.println("\nWith Runnable and array");
        sequenceFromThreads.processWRunnable();

        System.out.println("\nWith Runnable evenly among workers");
        sequenceFromThreads.processWRunnableEven();

    }

    private void processWCallableAtomic() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(threads);
        Future<Integer>[] futures = new Future[threads];
        for (int i=0;i<threads;i++) {
            futures[i] = service.submit(new Callable1(seqAtomic));
        }
        for (int i=0;i<threads;i++) {
            while (!futures[i].isDone()) {
                Thread.sleep(1000);
            }
        }
        service.shutdown();
    }
    private void processWRunnableAtomic() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(threads);
        Future<Void>[] futures = new Future[threads];
        for (int i=0;i<threads;i++) {
            futures[i] = service.submit(new Callable1(seqAtomic));
        }
        for (int i=0;i<threads;i++) {
            while (!futures[i].isDone()) {
                Thread.sleep(1000);
            }
        }
        service.shutdown();
    }

    private void processWCallable() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(threads);
        Future<Void>[] futures = new Future[threads];
        for (int i=0;i<threads;i++) {
            futures[i] = service.submit(new Callable2(seqInt));
        }
        for (int i=0;i<threads;i++) {
            while (!futures[i].isDone()) {
                Thread.sleep(1000);
            }
        }
        service.shutdown();
    }
    private void processWRunnable() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(threads);
        Future<Void>[] futures = new Future[threads];
        for (int i=0;i<threads;i++) {
            futures[i] = service.submit(new Callable2(seqInt));
        }
        for (int i=0;i<threads;i++) {
            while (!futures[i].isDone()) {
                Thread.sleep(1000);
            }
        }
        service.shutdown();
    }

    private void processWRunnableEven() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(threads);
        for (int i=0;i<threads;i++) cyclicBarriers[i] = new CyclicBarrier(2);
        Future[] futures = new Future[threads];
        for (int i=0;i<threads;i++) {
            futures[i] = service.submit(new Runnable3(i==0 ? true : false, seqAtomic, cyclicBarriers[i==0 ? 3 : i-1], cyclicBarriers[i]));
        }
        for (int i=threads-1;i>=0;i--) {
            while (!futures[i].isDone()) {
                Thread.sleep(1000);
            }
            System.out.println("Worker-" + i + " completed.");
        }
        service.shutdown();
    }

}

// Callable: can return result and throw checked Exception
class Callable1 implements Callable {
    AtomicInteger seq;
    public Callable1(AtomicInteger seq) {
        this.seq = seq;
    }
    @Override
    public Integer call() {
        for (int i=0;i<5;i++) {
            System.out.println(Thread.currentThread().getName() + ": " + seq.getAndIncrement());
        }
        return 0;
    }
}

// Callable: can return result and throw checked Exception
class Callable2 implements Callable {
    int[] seq;
    public Callable2(int[] seq) {
        this.seq = seq;
    }
    @Override
    public Integer call() {
        for (int i=0;i<5;i++) {
            synchronized (seq) {
                System.out.println(Thread.currentThread().getName() + ": " + seq[0]++);
            }
        }
        return 0;
    }
}

// Runnable: can't return result and throw checked Exception
class Runnable1 implements Runnable {
    AtomicInteger seq;

    public Runnable1(AtomicInteger seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + seq.getAndIncrement());
        }
    }
}
// Runnable: can't return result and throw checked Exception
class Runnable2 implements Runnable {
    int[] seq;
    public Runnable2(int[] seq) {
        this.seq = seq;
    }
    @Override
    public void run() {
        for (int i=0;i<5;i++) {
            synchronized(seq) {
                System.out.println(Thread.currentThread().getName() + ": " + seq[0]++);
            }
        }
    }
}

// Evenly distribute work among threads
class Runnable3 implements Runnable {
    AtomicInteger seq;
    boolean isLeader;
    CyclicBarrier waitfor, self;
    public Runnable3(boolean isLeader, AtomicInteger seq, CyclicBarrier waitfor, CyclicBarrier self) {
        this.isLeader = isLeader;
        this.seq = seq;
        this.waitfor = waitfor;
        this.self = self;
    }

    @Override
    public void run() {
        int events = 5;
        if (isLeader) {
            try {
                self.await();      // Trigger the first to start
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < events; i++) {
            try {
                waitfor.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": " + seq.getAndIncrement());
            try {
                    self.await();
                    self.reset();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
