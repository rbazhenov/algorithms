package concurrency.vlad_zuev;

public class _5_Priority {

    private static final String MESSAGE_TEMPLATE_THREAD_NAME = "%s : %d\n";

    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        final Thread thread = new Thread(() -> printNameAndPriority(Thread.currentThread()));
        thread.start();

        printNameAndPriority(Thread.currentThread());
    }


    private static void printNameAndPriority(final Thread thread) {
        System.out.printf(MESSAGE_TEMPLATE_THREAD_NAME, thread.getName(), thread.getPriority());
    }
}
