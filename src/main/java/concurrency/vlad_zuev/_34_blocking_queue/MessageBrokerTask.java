package concurrency.vlad_zuev._34_blocking_queue;

import java.util.concurrent.TimeUnit;

public abstract class MessageBrokerTask <T> implements Runnable {
    private final MessageBroker<T> broker;
    private final long secondTimeout;

    public MessageBrokerTask(MessageBroker<T> broker, long secondTimeout) {
        this.broker = broker;
        this.secondTimeout = secondTimeout;
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        while (true) {
            try {
                executeOperation(broker);
                TimeUnit.SECONDS.sleep(secondTimeout);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    protected abstract void executeOperation(final MessageBroker<T> broker) throws InterruptedException;
}
