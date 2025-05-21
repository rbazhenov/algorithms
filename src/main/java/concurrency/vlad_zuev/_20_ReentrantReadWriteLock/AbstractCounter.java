package concurrency.vlad_zuev._20_ReentrantReadWriteLock;

import java.util.concurrent.locks.Lock;

public abstract class AbstractCounter {
    private long value;

    public final long getValue() {
        final Lock lock = this.getReadLock();
        lock.lock();
        try {
            return this.value;
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
