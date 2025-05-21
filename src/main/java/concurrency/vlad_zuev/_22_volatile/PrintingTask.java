package concurrency.vlad_zuev._22_volatile;

import java.util.concurrent.TimeUnit;

public class PrintingTask implements Runnable {
    private volatile boolean shouldPrint = true;

    public boolean isShouldPrint() {
        return shouldPrint;
    }

    public void setShouldPrint(boolean shouldPrint) {
        this.shouldPrint = shouldPrint;
    }

    @Override
    public void run() {
        try {
            while (shouldPrint) {
                System.out.println("I am working");
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
