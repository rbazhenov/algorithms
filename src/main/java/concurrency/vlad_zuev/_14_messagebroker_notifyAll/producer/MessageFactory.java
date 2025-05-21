package concurrency.vlad_zuev._14_messagebroker_notifyAll.producer;

import concurrency.vlad_zuev._14_messagebroker_notifyAll.model.Message;

public final class MessageFactory {
    private static final int INITIAL_NEXT_MESSAGE_INDEX = 1;
    private static final String TEMPLATE_CREATED_MESSAGE_DATA = "Message#%d";

    private int nextMessageIndex;

    public MessageFactory() {
        this.nextMessageIndex = INITIAL_NEXT_MESSAGE_INDEX;
    }

    public Message create() {
        return new Message(String.format(TEMPLATE_CREATED_MESSAGE_DATA, findAndIncrementNextMessageIndex()));
    }

    private synchronized int findAndIncrementNextMessageIndex () {
        return this.nextMessageIndex++;
    }
}