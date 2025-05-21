package concurrency.vlad_zuev;

import java.util.stream.IntStream;

/**
 * Установили приоритет 10 нашему потоку, но в итоге main с приоритетом 5 выполнился первым.
 * Не сработало. Не меняй приоритеты. Очередность записит от операционной системы.
 */
public class _5_Priority_2 {

    private static final String MESSAGE_MAIN_THREAD_FINISHED = "Main thread is finished.";

    public static void main(String[] args) {
        final Thread thread = new Thread(new Task());
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

        System.out.println(MESSAGE_MAIN_THREAD_FINISHED);
    }

    private static final class Task implements Runnable {
        private static final int RANGE_MIN = 0;
        private static final int RANGE_MAX = 100;

        @Override
        public void run() {
            IntStream.range(RANGE_MIN, RANGE_MAX).forEach(System.out::println);
        }
    }
}
