package concurrency.vlad_zuev._26_semaphoreAndPool;

public abstract class AbstractPoolTask<T> implements Runnable {
    private final AbstractPool<T> pool;

    public AbstractPoolTask(AbstractPool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        T object = pool.acquire();
        try {
            System.out.printf("%s was acquired\n", object);
            handle(object);
        } finally {
            System.out.printf("%s is being released\n", object);
            pool.release(object);
        }
    }

    protected abstract void handle(final T object);
}
