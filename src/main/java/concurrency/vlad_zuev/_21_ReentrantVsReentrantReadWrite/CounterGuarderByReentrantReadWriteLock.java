package concurrency.vlad_zuev._21_ReentrantVsReentrantReadWrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CounterGuarderByReentrantReadWriteLock extends AbstractCounter {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    @Override
    protected Lock getReadLock() {
        return readLock;
    }

    @Override
    protected Lock getWriteLock() {
        return writeLock;
    }
}
