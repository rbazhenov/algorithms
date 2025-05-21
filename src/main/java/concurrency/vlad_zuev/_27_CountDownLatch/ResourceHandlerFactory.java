package concurrency.vlad_zuev._27_CountDownLatch;

import java.util.concurrent.CountDownLatch;

public final class ResourceHandlerFactory extends ResourceTaskFactory {
    @Override
    protected ResourceHandler create(long id, CountDownLatch latch) {
        return new ResourceHandler(id, latch);
    }
}
