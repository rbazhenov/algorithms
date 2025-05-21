package concurrency.vlad_zuev._21_ReentrantVsReentrantReadWrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterGuarderByLock extends AbstractCounter {

    private final Lock lock = new ReentrantLock();

    @Override
    protected Lock getReadLock() {
        return this.lock;
    }

    @Override
    protected Lock getWriteLock() {
        return this.lock;
    }
}
