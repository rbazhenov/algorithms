package concurrency.vlad_zuev._14_messagebroker_notifyAll.producer;

import concurrency.vlad_zuev._14_messagebroker_notifyAll.broker.MessageBroker;
import concurrency.vlad_zuev._14_messagebroker_notifyAll.model.Message;

public class MessageProducerTask implements Runnable {

    private final MessageBroker messageBroker;
    private final MessageFactory messageFactory;

    public MessageProducerTask(MessageBroker messageBroker, final MessageFactory messageFactory) {
        this.messageBroker = messageBroker;
        this.messageFactory = messageFactory;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            final Message producedMessage = this.messageFactory.create();
            this.messageBroker.produce(producedMessage);
        }
    }

}
