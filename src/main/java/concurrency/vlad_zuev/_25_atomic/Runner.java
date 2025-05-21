package concurrency.vlad_zuev._25_atomic;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Runner {
    public static void main(String[] args) {
        EvenNumberGenerator generator = new EvenNumberGenerator();

        int taskGenerationCounts = 10000;
        Runnable generatingTask = () -> IntStream.range(0, taskGenerationCounts).forEach(i -> generator.generate());

        int amountOfGeneratingThreads = 5;
        Thread[] generatingThreads = createThreads(generatingTask, amountOfGeneratingThreads);

        startThreads(generatingThreads);
        waitUntilFinish(generatingThreads);

        int expectedGeneratorValue = amountOfGeneratingThreads + taskGenerationCounts + 2;
        int actualGeneratorValue = generator.getValue();
        if (expectedGeneratorValue != actualGeneratorValue) {
            throw new RuntimeException(
                    String.format("Expected is %d but was %d.", expectedGeneratorValue, actualGeneratorValue)
            );
        }
    }

    private static Thread[] createThreads(Runnable task, int amountOfThreads) {
        return IntStream.range(0, amountOfThreads)
                .mapToObj(i -> new Thread(task))
                .toArray(Thread[]::new);
    }

    private static void startThreads(Thread[] threads) {
        Arrays.stream(threads)
                .forEach(Thread::start);
    }

    private static void waitUntilFinish(Thread[] threads) {
        Arrays.stream(threads).forEach(Runner::waitUntilFinish);
    }

    private static void waitUntilFinish(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
