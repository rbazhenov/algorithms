package concurrency.vlad_zuev._34_blocking_queue;

public class MessageBrokerConsumingTask <T> extends MessageBrokerTask<T> {
    public MessageBrokerConsumingTask(MessageBroker<T> broker, long secondTimeout) {
        super(broker, secondTimeout);
    }

    @Override
    protected void executeOperation(MessageBroker<T> broker) throws InterruptedException {
        final T message = broker.take();
        System.out.println(message + " was consumed.");
    }
}
