package concurrency.vlad_zuev._34_blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayMessageBroker <T> extends MessageBroker<T> {

    public ArrayMessageBroker(final int capacity) {
        super(new ArrayBlockingQueue<>(capacity));
    }
}
