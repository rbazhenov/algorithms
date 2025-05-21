package concurrency.vlad_zuev;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class _11_MonitorStatic {
    private static final int INCREMENT_AMOUNT_FIRST_COUNTER = 500;
    private static final int INCREMENT_AMOUNT_SECOND_COUNTER = 600;
    private static int firstCounter = 0;
    private static int secondCounter = 0;

    private static final Object LOCK_TO_INCREMENT_FIRST_COUNTER = new Object();
    private static final Object LOCK_TO_INCREMENT_SECOND_COUNTER = new Object();

    public static void main(String[] args) throws InterruptedException {

        final Thread firstThread = createIncrementingCounterThread(INCREMENT_AMOUNT_FIRST_COUNTER, i -> incrementFirstCounter());
        final Thread secondThread = createIncrementingCounterThread(INCREMENT_AMOUNT_FIRST_COUNTER, i -> incrementFirstCounter());

        final Thread thirdThread = createIncrementingCounterThread(INCREMENT_AMOUNT_SECOND_COUNTER, i -> incrementSecondCounter());
        final Thread fourthThread = createIncrementingCounterThread(INCREMENT_AMOUNT_SECOND_COUNTER, i -> incrementSecondCounter());


        startThreads(firstThread, secondThread, thirdThread, fourthThread);
        waitUntilAreCompleted(firstThread, secondThread, thirdThread, fourthThread);

        System.out.println(firstCounter);
        System.out.println(secondCounter);
    }

    private static void incrementFirstCounter() {
//        synchronized (_11_Monitor.class) { //тоже самое, что и synchronized в сигнатуре статик метода класса
         synchronized (LOCK_TO_INCREMENT_FIRST_COUNTER) {
            firstCounter++;
        }
    }

    private static void incrementSecondCounter() {
        synchronized (LOCK_TO_INCREMENT_SECOND_COUNTER) {
            secondCounter++;
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
