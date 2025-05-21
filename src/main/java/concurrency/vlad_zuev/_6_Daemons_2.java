package concurrency.vlad_zuev;

public class _6_Daemons_2 {

    private static final String MESSAGE_TEMPLATE_THREAD_NAME_AND_DAEMON_STATUS = "%s : %b\n";

    public static void main(String[] args) throws InterruptedException {
        final Thread firstDaemonThread = new Thread(() -> {
           printThreadNameAndDaemonStatus(Thread.currentThread());
           final Thread secondDaemonThread = new Thread(() -> printThreadNameAndDaemonStatus(Thread.currentThread()));
           secondDaemonThread.start();
            try {
                secondDaemonThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        firstDaemonThread.setDaemon(true);
        firstDaemonThread.start();

        firstDaemonThread.join();
    }

    private static void printThreadNameAndDaemonStatus(final Thread thread) {
        System.out.printf(MESSAGE_TEMPLATE_THREAD_NAME_AND_DAEMON_STATUS, thread.getName(), thread.isDaemon());
    }
}
