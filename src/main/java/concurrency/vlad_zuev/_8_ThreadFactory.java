package concurrency.vlad_zuev;

import java.util.concurrent.ThreadFactory;

public class _8_ThreadFactory {

    private static final String MESSAGE_EXCEPTION_TEMPLATE = "Exception was thrown with message '%s' in thread '%s'. \n";

    public static void main(String[] args) throws InterruptedException {
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = (thread, exception)
                -> System.out.printf(MESSAGE_EXCEPTION_TEMPLATE, exception.getMessage(), thread.getName());

        final ThreadFactory threadFactory =
                new DaemonThreadWithUncaughtExceptionHandlerFactory(uncaughtExceptionHandler);

        final Thread firstThread = threadFactory.newThread(new Task());
        firstThread.start();
        final Thread secondThread = threadFactory.newThread(new Task());
        secondThread.start();

        firstThread.join();
        secondThread.join();
    }

    private static final class Task implements Runnable {

        private static final String EXCEPTION_MESSAGE = "I am exception";

        @Override
        public void run() {
            System.out.println(Thread.currentThread().isDaemon());
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
    }

    private static final class DaemonThreadWithUncaughtExceptionHandlerFactory implements ThreadFactory {

        private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

        private DaemonThreadWithUncaughtExceptionHandlerFactory(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        }

        @Override
        public Thread newThread(Runnable runnable) {
            final Thread thread = new Thread(runnable);
            thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            thread.setDaemon(true);
            return thread;
        }
    }
}
