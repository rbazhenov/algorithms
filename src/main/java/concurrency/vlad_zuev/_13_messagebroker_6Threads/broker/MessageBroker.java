package concurrency.vlad_zuev._13_messagebroker_6Threads.broker;

import concurrency.vlad_zuev._13_messagebroker_6Threads.consumer.MessageConsumerTask;
import concurrency.vlad_zuev._13_messagebroker_6Threads.model.Message;
import concurrency.vlad_zuev._13_messagebroker_6Threads.producer.MessageProducerTask;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

public final class MessageBroker {

    private static final String TEMPLATE_MESSAGE_OF_MESSAGE_IS_PRODUCED =
            "Message '%s' is produced by producer '%s'. Amount of messages before producing: %d\n";
    private static final String TEMPLATE_MESSAGE_OF_MESSAGE_IS_CONSUMED =
            "Message '%s' is consumed by consumer '%s' Amount of messages before consuming: %d.\n";

    private final Queue<Message> messagesToBeConsumed;
    private final int maxStoredMessages;

    public MessageBroker(int maxStoredMessages) {
        this.maxStoredMessages = maxStoredMessages;
        this.messagesToBeConsumed = new ArrayDeque<>(this.maxStoredMessages);
    }

    public synchronized void produce(final Message message, final MessageProducerTask producerTask) {
        try {
            while (!this.isShouldProduce(producerTask)) {
                super.wait();
            }
            this.messagesToBeConsumed.add(message);
            System.out.printf(TEMPLATE_MESSAGE_OF_MESSAGE_IS_PRODUCED, message, producerTask.getName(),
                    this.messagesToBeConsumed.size() - 1);
            super.notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized Optional<Message> consume(final MessageConsumerTask consumerTask) {
        try {
            while (!this.isShouldConsume(consumerTask)) {
                super.wait();
            }
            Message message = this.messagesToBeConsumed.poll();
            System.out.printf(TEMPLATE_MESSAGE_OF_MESSAGE_IS_CONSUMED, message, consumerTask.getName(),
                    this.messagesToBeConsumed.size() + 1);

            super.notify();
            return Optional.ofNullable(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return Optional.empty();
        }
    }

    private boolean isShouldProduce(final MessageProducerTask producerTask) {
        return this.messagesToBeConsumed.size() < this.maxStoredMessages
                && this.messagesToBeConsumed.size() <= producerTask.getMinAmountMessagesToConsume();
    }

    private boolean isShouldConsume(final MessageConsumerTask consumerTask) {
        return !this.messagesToBeConsumed.isEmpty()
                && this.messagesToBeConsumed.size() >= consumerTask.getMinAmountMessageToConsume();
    }
}
