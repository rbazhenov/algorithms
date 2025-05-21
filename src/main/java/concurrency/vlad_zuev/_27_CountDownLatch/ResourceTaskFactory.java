package concurrency.vlad_zuev._27_CountDownLatch;

import java.util.concurrent.CountDownLatch;

public abstract class ResourceTaskFactory {
    private long nextId;

    public final ResourceTask create(CountDownLatch latch) {
        return create(nextId++, latch);
    }

    protected abstract ResourceTask create(long id, final CountDownLatch latch);
}
