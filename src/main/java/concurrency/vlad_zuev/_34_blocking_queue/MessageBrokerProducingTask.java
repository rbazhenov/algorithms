package concurrency.vlad_zuev._34_blocking_queue;

import java.util.function.Supplier;

public class MessageBrokerProducingTask <T> extends MessageBrokerTask<T> {

    private final Supplier<T> messageSupplier;

    public MessageBrokerProducingTask(MessageBroker<T> broker, long secondTimeout, Supplier<T> messageSupplier) {
        super(broker, secondTimeout);
        this.messageSupplier = messageSupplier;
    }

    @Override
    protected void executeOperation(MessageBroker<T> broker) throws InterruptedException {
        final T message = messageSupplier.get();
        broker.put(message);
        System.out.println(message + " was produced.");
    }
}
