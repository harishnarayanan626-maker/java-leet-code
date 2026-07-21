import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    private final ReentrantLock[] forks;

    public DiningPhilosophers() {
        forks = new ReentrantLock[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        // Even philosophers pick left first.
        // Odd philosophers pick right first.
        if (philosopher % 2 == 0) {

            forks[left].lock();
            forks[right].lock();

            try {
                pickLeftFork.run();
                pickRightFork.run();

                eat.run();

                putRightFork.run();
                putLeftFork.run();

            } finally {
                forks[right].unlock();
                forks[left].unlock();
            }

        } else {

            forks[right].lock();
            forks[left].lock();

            try {
                pickRightFork.run();
                pickLeftFork.run();

                eat.run();

                putLeftFork.run();
                putRightFork.run();

            } finally {
                forks[left].unlock();
                forks[right].unlock();
            }
        }
    }
}
