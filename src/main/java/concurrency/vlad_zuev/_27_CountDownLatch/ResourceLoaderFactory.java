package concurrency.vlad_zuev._27_CountDownLatch;

import java.util.concurrent.CountDownLatch;

public final class ResourceLoaderFactory extends ResourceTaskFactory {
    private long nextSecondDuration = 1;

    @Override
    protected ResourceLoader create(long id, CountDownLatch latch) {
        return new ResourceLoader(id, latch, nextSecondDuration);
    }
}
