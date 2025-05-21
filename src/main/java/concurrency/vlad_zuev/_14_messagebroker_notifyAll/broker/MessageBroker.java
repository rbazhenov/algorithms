package concurrency.vlad_zuev._14_messagebroker_notifyAll.broker;

import concurrency.vlad_zuev._14_messagebroker_notifyAll.model.Message;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

public final class MessageBroker {

    private static final String TEMPLATE_MESSAGE_OF_MESSAGE_IS_PRODUCED =
            "Message '%s' is produced.\n";
    private static final String TEMPLATE_MESSAGE_OF_MESSAGE_IS_CONSUMED =
            "Message '%s' is consumed.\n";

    private final Queue<Message> messagesToBeConsumed;
    private final int maxStoredMessages;

    public MessageBroker(int maxStoredMessages) {
        this.maxStoredMessages = maxStoredMessages;
        this.messagesToBeConsumed = new ArrayDeque<>(this.maxStoredMessages);
    }

    public synchronized void produce(final Message message) {
        try {
            while (this.messagesToBeConsumed.size() >= this.maxStoredMessages) {
//                super.wait();
                super.wait(1);
            }
            this.messagesToBeConsumed.add(message);
            System.out.printf(TEMPLATE_MESSAGE_OF_MESSAGE_IS_PRODUCED, message);
//            super.notifyAll();
            super.notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized Optional<Message> consume() {
        try {
            while (this.messagesToBeConsumed.isEmpty()) {
//                super.wait();
                super.wait(1);
            }
            Message message = this.messagesToBeConsumed.poll();
            System.out.printf(TEMPLATE_MESSAGE_OF_MESSAGE_IS_CONSUMED, message);

//            super.notifyAll();
            super.notify();
            return Optional.ofNullable(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return Optional.empty();
        }
    }
}
