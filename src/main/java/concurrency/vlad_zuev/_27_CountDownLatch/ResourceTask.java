package concurrency.vlad_zuev._27_CountDownLatch;

import java.util.concurrent.CountDownLatch;

public abstract class ResourceTask implements Runnable {
    private final long id;
    private final CountDownLatch latch;

    public ResourceTask(long id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        run(latch);
    }

    protected abstract void run(final CountDownLatch latch);

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id = " + id + "]";
    }
}
