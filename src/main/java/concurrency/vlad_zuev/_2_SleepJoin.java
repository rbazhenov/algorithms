package concurrency.vlad_zuev;

import java.util.stream.IntStream;

public class _2_SleepJoin {

    private static final int FROM_THREAD_1 = 1;
    private static final int TO_THREAD_1 = 500;

    private static final int FROM_THREAD_2 = 501;
    private static final int TO_THREAD_2 = 1000;

    private static final String TEMPLATE_MESSAGE_THREAD_NAME_AND_NUMBER = "%s : %s\n";

    private static final int TIME_WAITING_IN_MILLIS = 1000;

    public static void main(String[] args) throws InterruptedException {
//        final TaskSummingNumber firstTask = startSubTask(FROM_THREAD_1, TO_THREAD_1);
//        final TaskSummingNumber secondTask = startSubTask(FROM_THREAD_2, TO_THREAD_2);
        final TaskSummingNumber firstTask = new TaskSummingNumber(FROM_THREAD_1, TO_THREAD_1);
        final Thread firstThread = new Thread(firstTask);
        firstThread.start();

        final TaskSummingNumber secondTask = new TaskSummingNumber(FROM_THREAD_2, TO_THREAD_2);
        final Thread secondThread = new Thread(secondTask);
        secondThread.start();

        //без этого main считал сумму двух нулей
//        waitForTaskFinished();

        waitForTaskFinished(firstThread, secondThread);

        final int resultNumber = firstTask.getResultNumber() + secondTask.getResultNumber();
        printThreadNameAndNumber(resultNumber);
    }

    private static TaskSummingNumber startSubTask(final int fromNumber, final int toNumber) {
        final TaskSummingNumber subTask = new TaskSummingNumber(fromNumber, toNumber);
        final Thread thread = new Thread(subTask);

        thread.start();
        return subTask;
    }

    private static void printThreadNameAndNumber(final int number) {
        System.out.printf(TEMPLATE_MESSAGE_THREAD_NAME_AND_NUMBER, Thread.currentThread().getName(), number);
    }

    @Deprecated
    private static void waitForTaskFinished() throws InterruptedException {
        Thread.sleep(TIME_WAITING_IN_MILLIS);
    }

    private static void waitForTaskFinished (final Thread... threads) throws InterruptedException {
        //поток main Будет ждать, пока вссе потоки, которые мы передали, не выполнятся.
        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static final class TaskSummingNumber implements Runnable {
        private static final int INIT_NUMBER = 0;

        private final int fromNumber;
        private final int toNumber;
        private int resultNumber;

        public TaskSummingNumber(int fromNumber, int toNumber) {
            this.fromNumber = fromNumber;
            this.toNumber = toNumber;
            this.resultNumber = INIT_NUMBER;
        }

        public int getResultNumber() {
            return this.resultNumber;
        }

        @Override
        public void run() {
            IntStream.rangeClosed(this.fromNumber, this.toNumber).forEach(i -> this.resultNumber += i);
            printThreadNameAndNumber(resultNumber);
        }
    }
}
