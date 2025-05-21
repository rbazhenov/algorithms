package concurrency.vlad_zuev._26_semaphoreAndPool;

import java.util.concurrent.TimeUnit;

public class ConnectionPoolTask extends AbstractPoolTask<Connection> {

    public ConnectionPoolTask(AbstractPool<Connection> pool) {
        super(pool);
    }

    @Override
    protected void handle(Connection connection) {
        try {
            connection.setAutoCommit(false);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
