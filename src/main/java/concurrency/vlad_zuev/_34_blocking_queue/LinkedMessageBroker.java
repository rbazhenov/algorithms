package concurrency.vlad_zuev._34_blocking_queue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedMessageBroker<T> extends MessageBroker<T> {
    public LinkedMessageBroker(final int capacity) {
        super(new LinkedBlockingQueue<>(capacity));
    }
}
