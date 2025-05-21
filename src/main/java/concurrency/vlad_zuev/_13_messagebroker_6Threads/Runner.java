package concurrency.vlad_zuev._13_messagebroker_6Threads;

import concurrency.vlad_zuev._13_messagebroker_6Threads.broker.MessageBroker;
import concurrency.vlad_zuev._13_messagebroker_6Threads.consumer.MessageConsumerTask;
import concurrency.vlad_zuev._13_messagebroker_6Threads.producer.MessageFactory;
import concurrency.vlad_zuev._13_messagebroker_6Threads.producer.MessageProducerTask;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        final int brokerMaxStoredMessages = 15;
        MessageBroker messageBroker = new MessageBroker(brokerMaxStoredMessages);

        final MessageFactory messageFactory = new MessageFactory();

        final Thread firstProducingThread = new Thread(new MessageProducerTask(messageBroker, messageFactory,
                brokerMaxStoredMessages, "PRODUCER_1"));
        final Thread secondProducingThread = new Thread(new MessageProducerTask(messageBroker, messageFactory,
                10, "PRODUCER_2"));
        final Thread thirdProducingThread = new Thread(new MessageProducerTask(messageBroker, messageFactory,
                5, "PRODUCER_3"));

        final Thread firstConsumingThread = new Thread(new MessageConsumerTask(messageBroker,
                0, "CONSUMER_1"));
        final Thread secondConsumingThread = new Thread(new MessageConsumerTask(messageBroker,
                6, "CONSUMER_2"));
        final Thread thirdConsumingThread = new Thread(new MessageConsumerTask(messageBroker,
                11, "CONSUMER_3"));

        startThreads(firstProducingThread, secondProducingThread, thirdProducingThread, firstConsumingThread,
                secondConsumingThread, thirdConsumingThread);
    }

    private static void startThreads(final Thread... threads) {
        Arrays.stream(threads).forEach(Thread::start);
    }
}
