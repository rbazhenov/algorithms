package concurrency.vlad_zuev._27_CountDownLatch;

import concurrency.vlad_zuev._26_semaphoreAndPool.ThreadUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ResourceLoader extends ResourceTask {
    private final long secondDuration;

    public ResourceLoader(long id, CountDownLatch latch, long secondDuration) {
        super(id, latch);
        this.secondDuration = secondDuration;
    }

    @Override
    protected void run(CountDownLatch latch) {
        try {
            System.out.printf("%s is loading some resource.\n", this);
            TimeUnit.SECONDS.sleep(secondDuration);
            System.out.printf("Some resource was loaded by %s.\n", this);
            latch.countDown();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
