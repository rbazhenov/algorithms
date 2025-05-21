package concurrency.vlad_zuev._21_ReentrantVsReentrantReadWrite;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

//643226136 CounterGuarderByLock
//27238083 CounterGuarderByReentrantReadWriteLock

//54 CounterGuarderByLock
//249 CounterGuarderByReentrantReadWriteLock
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        testCounter(CounterGuarderByLock::new);
//        testCounter(CounterGuarderByReentrantReadWriteLock::new);
    }

    private static void testCounter(Supplier<? extends AbstractCounter> counterFactory) throws InterruptedException {
        AbstractCounter counter = counterFactory.get();

        int amountOfThreadsGettingValue = 50;
        ReadingValueTask[] readingValueTasks = createReadingTasks(counter, amountOfThreadsGettingValue);
        Thread[] readingValueThreads = mapToThreads(readingValueTasks);

        Runnable incrementingCounterTask = createIncrementingCounterTask(counter);
        int amountOfThreadsIncrementingCounter = 2;
        Thread[] incrementCounterThreads = createThreads(incrementingCounterTask, amountOfThreadsIncrementingCounter);

        startThreads(readingValueThreads);
        startThreads(incrementCounterThreads);

        TimeUnit.SECONDS.sleep(5);

        interruptThreads(readingValueThreads);
        interruptThreads(incrementCounterThreads);

        waitUntilFinish(readingValueThreads);

        long totalAmountOfReads = findTotalAmountOfReads(readingValueTasks);
        System.out.printf("Amount of reading value: %d", totalAmountOfReads);
    }

    private static ReadingValueTask[] createReadingTasks(AbstractCounter counter, int amountOfTasks) {
        return IntStream.range(0, amountOfTasks)
                .mapToObj(i -> new ReadingValueTask(counter))
                .toArray(ReadingValueTask[]::new);
    }

    private static Thread[] mapToThreads(Runnable[] tasks) {
        return Arrays.stream(tasks)
                .map(Thread::new)
                .toArray(Thread[]::new);
    }

    private static Runnable createIncrementingCounterTask(AbstractCounter counter) {
        return () -> {
            while (!Thread.currentThread().isInterrupted()) {
                incrementCounter(counter);
            }
        };
    }

    private static void incrementCounter(AbstractCounter counter) {
        try {
            counter.increment();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static Thread[] createThreads(Runnable task, int amountOfThreads) {
        return IntStream.range(0, amountOfThreads)
                .mapToObj(i -> new Thread(task))
                .toArray(Thread[]::new);
    }

    private static void startThreads(Thread[] threads) {
        Arrays.stream(threads)
                .forEach(Thread::start);
    }

    private static void interruptThreads(Thread[] threads) {
        forEach(threads, Thread::interrupt);
    }

    private static void forEach(Thread[] threads, Consumer<Thread> action) {
        Arrays.stream(threads).forEach(action);
    }

    private static void waitUntilFinish(Thread[] threads) {
        forEach(threads, Runner::waitUntilFinish);
    }

    private static void waitUntilFinish(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static long findTotalAmountOfReads(ReadingValueTask[] tasks) {
        return Arrays.stream(tasks)
                .mapToLong(ReadingValueTask::getAmountOfReads)
                .sum();
    }

    private static final class ReadingValueTask implements Runnable {
        private final AbstractCounter counter;
        private long amountOfReads;

        public ReadingValueTask(AbstractCounter counter) {
            this.counter = counter;
        }

        public long getAmountOfReads() {
            return amountOfReads;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                counter.getValue();
                amountOfReads++;
            }
        }
    }
}
