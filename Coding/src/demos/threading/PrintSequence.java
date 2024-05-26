package demos.threading;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintSequence {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        Object monitor = new Object();
        new Thread(new PrintSeq(0, count, monitor)).start();
        new Thread(new PrintSeq(1, count, monitor)).start();
        new Thread(new PrintSeq(2, count, monitor)).start();

        while (count.get() < 100) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.exit(0);
    }
}

class PrintSeq implements Runnable{
    AtomicInteger count;
    Object monitor;
    int id;
    public PrintSeq(int id, AtomicInteger count, Object monitor) {
        this.id = id;
        this.count = count;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while(count.get()<100) print();
    }
    private void print() {
        synchronized (monitor) {
            if (count.get() % 3 == id) {
                System.out.format("%d:%d\n", id, count.getAndIncrement());
                monitor.notifyAll();
            } else {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}