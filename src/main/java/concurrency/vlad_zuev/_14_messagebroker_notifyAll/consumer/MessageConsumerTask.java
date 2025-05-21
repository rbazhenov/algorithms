package concurrency.vlad_zuev._14_messagebroker_notifyAll.consumer;

import concurrency.vlad_zuev._14_messagebroker_notifyAll.broker.MessageBroker;

public class MessageConsumerTask implements Runnable {

    private final MessageBroker messageBroker;

    public MessageConsumerTask(MessageBroker messageBroker) {
        this.messageBroker = messageBroker;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            this.messageBroker.consume().orElseThrow(MessageConsumerException::new);
        }
    }
}
