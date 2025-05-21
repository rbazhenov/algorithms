package concurrency.vlad_zuev._22_volatile;

import java.util.concurrent.TimeUnit;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        PrintingTask printingTask = new PrintingTask();
        Thread printingThread = new Thread(printingTask);

        printingThread.start();

        TimeUnit.SECONDS.sleep(5);

        printingTask.setShouldPrint(false);
        System.out.println("Printing should be stopped");
    }
}
