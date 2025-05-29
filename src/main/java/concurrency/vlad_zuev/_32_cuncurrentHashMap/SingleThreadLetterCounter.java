package concurrency.vlad_zuev._32_cuncurrentHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SingleThreadLetterCounter extends LetterCounter {

    public SingleThreadLetterCounter() {
        super(1);
    }

    @Override
    protected Map<Character, Integer> createAccumulator() {
        return new HashMap<>();
    }

    @Override
    protected void execute(Stream<Subtask> subtasks) {
        subtasks.forEach(Subtask::execute);
    }
}
