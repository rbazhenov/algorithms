package concurrency.vlad_zuev._26_semaphoreAndPool;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractPool<T> {
    private final List<PoolObject<T>> poolObjects;
    private final Semaphore semaphore;

    public AbstractPool(Supplier<T> objectSupplier, int size) {
        this.poolObjects = createPoolObjects(objectSupplier,size);
        this.semaphore = new Semaphore(size);
    }

    public final T acquire() {
        semaphore.acquireUninterruptibly();
        return acquireObject();
    }

    public final void release(T object) {
        if (releaseObject(object)) {
            semaphore.release();
        }
    }

    protected abstract void cleanObject(T object);

    private static <T>List<PoolObject<T>> createPoolObjects(Supplier<T> objectSupplier, int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> objectSupplier.get())
                .map(object -> new PoolObject<>(object, false))
                .collect(Collectors.toList());
    }

    private synchronized T acquireObject() {
        return this.poolObjects.stream()
                .filter(poolObject -> !poolObject.isIssued())
                .findFirst()
                .map(AbstractPool::markAsIssued)
                .map(PoolObject::getObject)
                .orElseThrow(IllegalArgumentException::new);
    }

    private static <T> PoolObject<T> markAsIssued(PoolObject<T> poolObject) {
        poolObject.setIssued(true);
        return poolObject;
    }

    private synchronized boolean releaseObject(final T object) {
        return poolObjects.stream()
                .filter(PoolObject::isIssued)
                .filter(poolObject -> Objects.equals(poolObject.getObject(), object))
                .findFirst()
                .map(this::cleanPoolObject)
                .isPresent();
    }

    private PoolObject<T> cleanPoolObject(PoolObject<T> poolObject) {
        poolObject.setIssued(false);
        cleanObject(poolObject.getObject());
        return poolObject;
    }

    private static final class PoolObject<T> {
        private final T object;
        private boolean issued; //выдан

        public PoolObject(T object, boolean issued) {
            this.object = object;
            this.issued = issued;
        }

        public T getObject() {
            return object;
        }

        public boolean isIssued() {
            return issued;
        }

        public void setIssued(boolean issued) {
            this.issued = issued;
        }
    }
}
