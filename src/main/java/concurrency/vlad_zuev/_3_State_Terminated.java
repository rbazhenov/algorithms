package concurrency.vlad_zuev;

public class _3_State_Terminated {
    private static final String MESSAGE_TEMPLATE_THREAD_STATE = "%s : %s\n";


    public static void main(String[] args) throws InterruptedException, RuntimeException {
//        final Thread thread = new Thread(() -> showThreadState(Thread.currentThread()));
        final Thread thread = new Thread(() -> {
            throw new RuntimeException();
        });
        thread.start();
        thread.join();
        showThreadState(thread);
    }

    private static void showThreadState(final Thread thread) {
        System.out.printf(MESSAGE_TEMPLATE_THREAD_STATE, thread.getName(), thread.getState());
    }
}
