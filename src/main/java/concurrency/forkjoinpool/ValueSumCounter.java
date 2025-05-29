package concurrency.forkjoinpool;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ValueSumCounter extends RecursiveTask<Integer> {

    private int[] array;

    public ValueSumCounter(int[] array) {
        this.array = array;
    }

    //    @SneakyThrows
    @Override
    protected Integer compute() {
        try {
            if (array.length <= 2) {
                System.out.printf("Task %s execute in thread %s%n", this, Thread.currentThread().getName());
                Thread.sleep(1);
                return Arrays.stream(array).sum();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ValueSumCounter firstHalfArrayValueSumCounter = new ValueSumCounter(Arrays.copyOfRange(array, 0, array.length / 2));
        ValueSumCounter secondHalfArrayValueSumCounter = new ValueSumCounter(Arrays.copyOfRange(array, array.length / 2, array.length));
        firstHalfArrayValueSumCounter.fork();
        secondHalfArrayValueSumCounter.fork();
        return firstHalfArrayValueSumCounter.join() + secondHalfArrayValueSumCounter.join();
    }
}
