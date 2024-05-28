package demos.threading;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    Semaphore[] semaphores;
    int[] counts;
    public DiningPhilosophers() {
        semaphores = new Semaphore[5];
        semaphores[0] = new Semaphore(1);
        semaphores[1] = new Semaphore(0);
        semaphores[2] = new Semaphore(1);
        semaphores[3] = new Semaphore(0);
        semaphores[4] = new Semaphore(0);

        counts = new int[5];

        Scanner scanner = new Scanner(System.in);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while (true) {
            semaphores[philosopher].acquire();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            counts[philosopher]++;
            System.out.println(philosopher + ": " + counts[philosopher]);
            semaphores[(philosopher+1)%5].release();
            if (counts[philosopher] >= 2) return;

        }
    }
}