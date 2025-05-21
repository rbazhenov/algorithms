package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class SberTask {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger i = null;
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                increase(i);
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                print(i);
            }
        };

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void increase(AtomicInteger i) {
        while (true) {
            if (i == null) {
                i = new AtomicInteger(0);
            } else {
                i.incrementAndGet();
            }
        }
    }

    private static void print(AtomicInteger i) {
        while (true) {
            if (i != null) {
                System.out.println(i.get());
            }
        }
    }
}
