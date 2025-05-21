package concurrency.vlad_zuev._21_ReentrantVsReentrantReadWrite;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public abstract class AbstractCounter {
    private long value;

    public final Optional<Long> getValue() {
        final Lock lock = this.getReadLock();
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            return Optional.of(this.value);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return Optional.empty();
        } finally {
            lock.unlock();
        }
    }

    public final void increment() {
        final Lock lock = getWriteLock();
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
    }

    protected abstract Lock getReadLock();
    protected abstract Lock getWriteLock();

}
