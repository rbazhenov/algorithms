package concurrency.vlad_zuev;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class _11_MonitorNotStatic {
    private static final int INCREMENT_AMOUNT_FIRST_COUNTER = 500;
    private static final int INCREMENT_AMOUNT_SECOND_COUNTER = 600;

    private static final Object LOCK_TO_INCREMENT_FIRST_COUNTER = new Object();
    private static final Object LOCK_TO_INCREMENT_SECOND_COUNTER = new Object();

    public static void main(String[] args) throws InterruptedException {
        final Counter firstCounter = new Counter();
        final Counter secondCounter = new Counter();

        final Thread firstThread = createIncrementingCounterThread(INCREMENT_AMOUNT_FIRST_COUNTER,
                i -> firstCounter.increment());
        final Thread secondThread = createIncrementingCounterThread(INCREMENT_AMOUNT_FIRST_COUNTER,
                i -> firstCounter.increment());

        final Thread thirdThread = createIncrementingCounterThread(INCREMENT_AMOUNT_SECOND_COUNTER,
                i -> secondCounter.increment());
        final Thread fourthThread = createIncrementingCounterThread(INCREMENT_AMOUNT_SECOND_COUNTER,
                i -> secondCounter.increment());


        startThreads(firstThread, secondThread, thirdThread, fourthThread);
        waitUntilAreCompleted(firstThread, secondThread, thirdThread, fourthThread);

        System.out.println(firstCounter.counter);
        System.out.println(secondCounter.counter);
    }

    private static final class Counter {
        private int counter;

        public synchronized void increment() {
            counter++;
        }
        //сверху и снизу одно и то же
        public void decrement() {
            synchronized(this) {
                counter--;
            }
        }
    }

    private static void startThreads(final Thread... threads) {
        Arrays.stream(threads).forEach(Thread::start);
    }

    private static void waitUntilAreCompleted(final Thread... threads) {
        Arrays.stream(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                thread.interrupt();
            }
        });
    }

    private static Thread createIncrementingCounterThread(final int incrementAmount,
                                                          final IntConsumer incrementingOperation) {
        return new Thread(() -> IntStream.range(0, incrementAmount).forEach(incrementingOperation));
    }
}
