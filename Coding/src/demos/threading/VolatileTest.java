package demos.threading;

public class VolatileTest {

    // volatile can only be used on instance fileds
    volatile boolean stop = false;
    volatile String s;

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.test();
    }

    public void test() throws InterruptedException {
        new Thread(()-> {
            while (!stop) {
                System.out.println("Waiting to be stopped");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) { }
            }
        }).start();

        Thread.sleep(2000);
        System.out.println("Stopping child");
        stop = true;
    }
}
