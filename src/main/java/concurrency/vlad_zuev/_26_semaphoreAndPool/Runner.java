package concurrency.vlad_zuev._26_semaphoreAndPool;

public class Runner {
    public static void main(String[] args) {
        final int poolSize = 3;
        final ConnectionPool pool = new ConnectionPool(poolSize);

        ConnectionPoolTask poolTask = new ConnectionPoolTask(pool);
        int threadCount = 15;
        final Thread[] threads = ThreadUtil.createThreads(poolTask, threadCount);
        ThreadUtil.startThreads(threads);
    }
}
