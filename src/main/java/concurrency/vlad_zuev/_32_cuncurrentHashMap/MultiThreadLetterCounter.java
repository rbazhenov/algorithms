package concurrency.vlad_zuev._32_cuncurrentHashMap;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class MultiThreadLetterCounter extends LetterCounter {

    public MultiThreadLetterCounter(int subTaskCount) {
        super(subTaskCount);
    }

    @Override
    protected Map<Character, Integer> createAccumulator() {
        return new ConcurrentHashMap<>();
    }

    @Override
    protected void execute(Stream<Subtask> subtasks) {
        final List<Thread> threads = run(subtasks);
        threads.forEach(this::waitUntilFinish);
    }

    private List<Thread> run(final Stream<Subtask> subtasks) {
        return subtasks.map(this::run).collect(Collectors.toList());
    }

    private Thread run(Subtask subtask) {
        final Thread thread = new Thread(subtask::execute);
        thread.start();
        return thread;
    }

    private void waitUntilFinish(final Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
