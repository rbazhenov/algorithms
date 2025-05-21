package concurrency.vlad_zuev;

import java.util.concurrent.TimeUnit;

public class _6_Daemons {

    private static final String MESSAGE_MAIN_THREAD_FINISHED = "Main thread is finished.";

    public static void main(String[] args) {
        final Thread thread = new Thread(new Task());
        thread.setDaemon(true);
        thread.start();

        System.out.println(thread.isDaemon());

        System.out.println(MESSAGE_MAIN_THREAD_FINISHED);
    }


    private static final class Task implements Runnable {
        private static final String MESSAGE = "I am working";

        @Override
        public void run() {
            while (true) {
                System.out.println(MESSAGE);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
