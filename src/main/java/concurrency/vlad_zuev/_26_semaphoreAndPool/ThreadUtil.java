package concurrency.vlad_zuev._26_semaphoreAndPool;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ThreadUtil {

    public static Thread[] createThreads(final Runnable task, int amountOfThreads) {
        return IntStream.range(0, amountOfThreads)
                .mapToObj(i -> new Thread(task))
                .toArray(Thread[]::new);
    }

    public static void startThreads(Thread[] threads) {
        Arrays.stream(threads).forEach(Thread::start);
    }

    private ThreadUtil() {
        throw new UnsupportedOperationException();
    }
}
