package demos.threading;

public class ThreadLocalTest {

    public static void main(String[] args) {
        new ThreadLocalTest().test();
    }

    private void test() {
        Service service = new Service();
        new Thread(new ARunnable(service, 2)).start();
        new Thread(new ARunnable(service, 1)).start();
    }
}

class ARunnable implements Runnable{

    private Service service;
    public ARunnable(Service service, int seed) {
        this.service = service;
        service.setSeedInstance(seed);
    }
    @Override
    public void run() {
        service.getThreadLocal().set(Thread.currentThread().getName());
        service.service();
    }
}

class Service {
    private ThreadLocal<String> executingThread = new ThreadLocal<>();  // Thread specific value
    private int seedInstance;       // Instance variable has value from last update
    public ThreadLocal<String> getThreadLocal() {
        return executingThread;
    }
    public void setSeedInstance(int seed) {
        this.seedInstance = seed;
    }
    public int getSeedInstance() {
        return seedInstance;
    }
    public void service() {
        System.out.format("Executing thread: %s, seedInstance: %d\n", executingThread.get(), seedInstance);
    }
}