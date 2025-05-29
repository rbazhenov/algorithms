package concurrency.vlad_zuev._34_blocking_queue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousMessageBroker <T> extends MessageBroker<T> {

    public SynchronousMessageBroker(){
        super(new SynchronousQueue<>());
    }
}
