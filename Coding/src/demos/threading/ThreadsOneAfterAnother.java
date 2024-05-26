package demos.threading;

public class ThreadsOneAfterAnother {

    public static void main(String[] args) throws InterruptedException {
        int n = 5;

        ThreadsOneAfterAnother threadsOneAfterAnother = new ThreadsOneAfterAnother();
        threadsOneAfterAnother.test1(n);
        System.out.println("-----------------------");
        threadsOneAfterAnother.test2(n);
    }

    // start and complete one after another
    private void test1(int n) throws InterruptedException {
        Thread[] threads = new Thread[n];
        for (int i=0;i<threads.length;i++) threads[i] = new Thread(new Runnable_1(i));
        for (int i=0;i<threads.length;i++) {
            threads[i].start();
            threads[i].join();
        }
    }

    // all threads start but execute one after another, controlled by one permit being passed around
    private void test2(int n) {
        Semaphore[] semaphores = new Semaphore[n];
        semaphores[0] = new Semaphore(1);
        for (int i=1;i<n;i++) semaphores[i] = new Semaphore(0);
        for (int i=0;i<n;i++) (new Thread(new Runnable_2(i,semaphores))).start();

    }
}
class Runnable_1 implements Runnable {
    int id;

    public Runnable_1(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        System.out.format("Thread-%d\n", id);
    }
}
class Runnable_2 implements Runnable {
    int id;
    Semaphore[] semaphores;

    public Runnable_2(int id, Semaphore[] semaphores) {
        this.id = id;
        this.semaphores = semaphores;
    }
    @Override
    public void run() {
        for (int i=0;i<5;i++) {
            semaphores[id].acquire();
            System.out.format("Thread-%d\n", id);
            semaphores[(id + 1) % semaphores.length].release();
        }
    }
}