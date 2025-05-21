package concurrency.vlad_zuev;

public class _7_Exception {

    private static final String MESSAGE_EXCEPTION_TEMPLATE = "Exception was thrown with message '%s' in thread '%s'. \n";

    public static void main(String[] args) {
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = (thread, exception)
                -> System.out.printf(MESSAGE_EXCEPTION_TEMPLATE, exception.getMessage(), thread.getName());

        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);

        final Thread firstThread = new Thread(new Task());
//        firstThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        firstThread.start();

        final Thread secondThread = new Thread(new Task());
//        secondThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        secondThread.start();
    }

    private static final class Task implements Runnable {

        private static final String EXCEPTION_MESSAGE = "I am exception";

        @Override
        public void run() {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
    }
}
