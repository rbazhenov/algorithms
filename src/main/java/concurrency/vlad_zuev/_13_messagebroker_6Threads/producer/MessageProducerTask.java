package concurrency.vlad_zuev._13_messagebroker_6Threads.producer;

import concurrency.vlad_zuev._13_messagebroker_6Threads.broker.MessageBroker;
import concurrency.vlad_zuev._13_messagebroker_6Threads.model.Message;

import java.util.concurrent.TimeUnit;

public class MessageProducerTask implements Runnable {
    private static final int SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING = 1;

    private final MessageBroker messageBroker;
    private final MessageFactory messageFactory;
    private final int minAmountMessagesToConsume;
    private final String name;

    public MessageProducerTask(MessageBroker messageBroker, final MessageFactory messageFactory,
                               int minAmountMessagesToConsume, final String name) {
        this.messageBroker = messageBroker;
        this.messageFactory = messageFactory;
        this.minAmountMessagesToConsume = minAmountMessagesToConsume;
        this.name = name;
    }

    public int getMinAmountMessagesToConsume() {
        return minAmountMessagesToConsume;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                final Message producedMessage = this.messageFactory.create();
                TimeUnit.SECONDS.sleep(SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING);

                this.messageBroker.produce(producedMessage, this);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer exception");
            Thread.currentThread().interrupt();
        }
    }

}
