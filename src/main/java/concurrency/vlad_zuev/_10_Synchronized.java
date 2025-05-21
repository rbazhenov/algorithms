package concurrency.vlad_zuev;

import java.util.stream.IntStream;

public class _10_Synchronized {
    private static final int INCREMENT_AMOUNT_FIRST_THREAD = 500;
    private static final int INCREMENT_AMOUNT_SECOND_THREAD = 600;
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        final Thread firstThread = createIncrementingCounterThread(INCREMENT_AMOUNT_FIRST_THREAD);
        final Thread secondThread = createIncrementingCounterThread(INCREMENT_AMOUNT_SECOND_THREAD);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println(counter);
    }

    //решили состояние гонки
    public static synchronized void incrementSynchronized() {
        counter++;
    }

    private static Thread createIncrementingCounterThread(final int incrementAmount) {
        return new Thread(() -> IntStream.range(0, incrementAmount).forEach(i -> incrementSynchronized()));
    }
}
