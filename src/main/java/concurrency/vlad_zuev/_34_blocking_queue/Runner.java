package concurrency.vlad_zuev._34_blocking_queue;

import java.util.concurrent.ThreadLocalRandom;

public class Runner {
    public static void main(String[] args) {
        final MessageBroker<Integer> broker = new SynchronousMessageBroker<>();

        startProducing(broker, 1);
        startProducing(broker, 3);
        startProducing(broker, 5);

        startConsuming(broker, 5);
        startConsuming(broker, 3);
        startConsuming(broker, 1);
    }

    private static void startProducing(MessageBroker<Integer> broker, long secondTimeout) {
        new Thread(new MessageBrokerProducingTask<>(broker, secondTimeout, Runner::generateInt)).start();
    }

    private static void startConsuming(MessageBroker<Integer> broker, long secondTimeout) {
        new Thread(new MessageBrokerConsumingTask<>(broker, secondTimeout)).start();
    }

    private static int generateInt() {
        return ThreadLocalRandom.current().nextInt(0, 10);
    }
}
