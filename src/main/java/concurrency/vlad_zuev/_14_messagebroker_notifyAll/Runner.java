package concurrency.vlad_zuev._14_messagebroker_notifyAll;

import concurrency.vlad_zuev._14_messagebroker_notifyAll.broker.MessageBroker;
import concurrency.vlad_zuev._14_messagebroker_notifyAll.consumer.MessageConsumerTask;
import concurrency.vlad_zuev._14_messagebroker_notifyAll.producer.MessageFactory;
import concurrency.vlad_zuev._14_messagebroker_notifyAll.producer.MessageProducerTask;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        final int brokerMaxStoredMessages = 1;
        MessageBroker messageBroker = new MessageBroker(brokerMaxStoredMessages);

        final MessageFactory messageFactory = new MessageFactory();

        final Thread firstProducingThread = new Thread(new MessageProducerTask(messageBroker, messageFactory));
        final Thread secondProducingThread = new Thread(new MessageProducerTask(messageBroker, messageFactory));

        final Thread consumingThread = new Thread(new MessageConsumerTask(messageBroker));

        startThreads(firstProducingThread, secondProducingThread, consumingThread);
    }

    private static void startThreads(final Thread... threads) {
        Arrays.stream(threads).forEach(Thread::start);
    }
}
