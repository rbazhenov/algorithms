package sorokin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _3_Foot implements Runnable {

    private volatile static int footIndex = 0;
    private final String name;
    private final String lock = "lock";

    public _3_Foot(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                step();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void step() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (footIndex == 0 && name.equals("left") || footIndex == 1 && name.equals("right")) {
                    System.out.println("Step by: " + name);
                    footIndex = (footIndex + 1) % 2;

                    TimeUnit.SECONDS.sleep(1);
                    lock.notify();
                    return;
                } else {
                    lock.wait();
                }
            }

        }
    }
}

class Robot {
    public static void main(String[] args) {
        _3_Foot task1 = new _3_Foot("left");
        _3_Foot task2 = new _3_Foot("right");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(task1);
        executorService.submit(task2);
    }
}
