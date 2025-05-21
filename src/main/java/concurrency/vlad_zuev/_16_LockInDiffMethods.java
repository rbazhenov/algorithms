package concurrency.vlad_zuev;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class _16_LockInDiffMethods {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        final int incrementAmount = 10;
        final Thread incrementingThread = new Thread(
                createTaskDoingOperationOnCounter(counter, i -> counter.increment(), incrementAmount)
        );

        final int decrementAmount = 10;
        final Thread decrementingThread = new Thread(
                createTaskDoingOperationOnCounter(counter, i -> counter.decrement(), decrementAmount)
        );

        startThreads(incrementingThread, decrementingThread);
        waitUntilFinish(incrementingThread, decrementingThread);

        System.out.printf("Counter's value: %d.\n", counter.getValue());
    }

    private static void startThreads(Thread... threads) {
        Arrays.stream(threads).forEach(Thread::start);
    }

    private static void waitUntilFinish(Thread... threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static Runnable createTaskDoingOperationOnCounter(final Counter counter, final IntConsumer operation,
                                                              final int times) {
        return () -> {
            counter.lock();
            try {
                IntStream.range(0, times).forEach(operation);
            } finally {
                counter.unlock();
            }
        };
    }

    private static final class Counter {
        private final Lock lock = new ReentrantLock();
        private int value;

        private static void printMessageWithCurrentThreadNameArgument(String message) {
            System.out.printf(message, Thread.currentThread().getName());
        }

        public void lock() {
            this.lock.lock();
            printMessageWithCurrentThreadNameArgument("Thread '%s' locked counter.\n");
        }

        public void increment() {
            this.value++;
            printMessageWithCurrentThreadNameArgument("Thread '%s' incremented counter.\n");
        }

        public void decrement() {
            this.value--;
            printMessageWithCurrentThreadNameArgument("Thread '%s' decremented counter.\n");
        }

        public void unlock() {
            printMessageWithCurrentThreadNameArgument("Thread '%s' is unlocking counter.\n");
            this.lock.unlock();
        }

        public int getValue() {
            return value;
        }
    }
}
