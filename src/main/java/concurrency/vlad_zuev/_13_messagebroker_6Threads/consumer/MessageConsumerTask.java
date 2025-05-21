package concurrency.vlad_zuev._13_messagebroker_6Threads.consumer;

import concurrency.vlad_zuev._13_messagebroker_6Threads.broker.MessageBroker;

import java.util.concurrent.TimeUnit;

public class MessageConsumerTask implements Runnable {

    private static final int SECONDS_DURATION_TO_SLEEP_BEFORE_CONSUMING = 3;

    private final MessageBroker messageBroker;
    private final int minAmountMessageToConsume;
    private final String name;

    public MessageConsumerTask(MessageBroker messageBroker, int minAmountMessageToConsume, String name) {
        this.messageBroker = messageBroker;
        this.minAmountMessageToConsume = minAmountMessageToConsume;
        this.name = name;
    }

    public int getMinAmountMessageToConsume() {
        return minAmountMessageToConsume;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                TimeUnit.SECONDS.sleep(SECONDS_DURATION_TO_SLEEP_BEFORE_CONSUMING);
                this.messageBroker.consume(this).orElseThrow(MessageConsumerException::new);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
