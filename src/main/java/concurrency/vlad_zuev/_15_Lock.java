package concurrency.vlad_zuev;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class _15_Lock {
    public static void main(String[] args) {
        final EvenNumberGenerator generator = new EvenNumberGenerator();

        final Runnable generatingTask = () -> IntStream.range(0, 100)
                .forEach(i -> System.out.println(generator.generate()));

        final Thread firstThread = new Thread(generatingTask);
        firstThread.start();
        final Thread secondThread = new Thread(generatingTask);
        secondThread.start();
        final Thread thirdThread = new Thread(generatingTask);
        thirdThread.start();
    }

    private static final class EvenNumberGenerator {
        private final Lock lock;

        private int previousGenerator;

        public EvenNumberGenerator() {
            lock = new ReentrantLock();
            this.previousGenerator = -2;
        }

        public int generate() {
            this.lock.lock();
            try {
                return this.previousGenerator += 2;
            } finally {
                this.lock.unlock();
            }
        }
    }
}
