package concurrency.vlad_zuev;

import java.util.concurrent.TimeUnit;

public class _4_ThreadTerminatingWithInterrupted {

    private static final String MESSAGE_REQUEST_WAS_SENT = "\nRequest was sent.";
    private static final int DURATION_IN_SECONDS_DELIVERING_RESPONSE = 1;
    private static final String MESSAGE_RESPONSE_WAS_RECEIVED = "Response was received.";
    private static final String MESSAGE_SERVER_WAS_STOPPED = "Server was stopped.";
    private static final int TIME_WAITING_IN_SECONDS_TO_START_STOPPING = 5;

    private static final String MESSAGE_THREAD_WAS_INTERRUPTED = "Thread was interrupted.";


    public static void main(String[] args) throws InterruptedException {
        final Thread communicatingThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    doRequest();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getState());
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println(MESSAGE_THREAD_WAS_INTERRUPTED);
            }
        });
        communicatingThread.start();

        final Thread stoppingThread = new Thread(() -> {
            if (isServerShouldBeOffed()) {
                communicatingThread.interrupt();
                stopServer();
            }
        });
        TimeUnit.SECONDS.sleep(TIME_WAITING_IN_SECONDS_TO_START_STOPPING);
        stoppingThread.start();
    }

    private static void doRequest() throws InterruptedException {
        System.out.println(MESSAGE_REQUEST_WAS_SENT);
        TimeUnit.SECONDS.sleep(DURATION_IN_SECONDS_DELIVERING_RESPONSE);
        System.out.println(MESSAGE_RESPONSE_WAS_RECEIVED);
    }

    private static boolean isServerShouldBeOffed() {
        return true;
    }

    private static void stopServer() {
        System.out.println(MESSAGE_SERVER_WAS_STOPPED);
    }
}
