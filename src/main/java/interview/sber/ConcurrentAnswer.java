package interview.sber;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentAnswer {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger i = new AtomicInteger(0);
        Thread thread1 = new Thread(() -> increase(i));
        Thread thread2 = new Thread(() -> print(i));

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
