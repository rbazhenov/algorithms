package concurrency.vlad_zuev._32_cuncurrentHashMap;

import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class LetterCounter {
    private final int subTaskCount;

    public LetterCounter(int subTaskCount) {
        this.subTaskCount = subTaskCount;
    }

    public final Map<Character, Integer> count(String input) {
        Map<Character, Integer> accumulator = createAccumulator();
        Stream<Subtask> subtasks = createSubtasks(accumulator, input);
        execute(subtasks);
        return accumulator;
    }

    private Stream<Subtask> createSubtasks(Map<Character,Integer> accumulator, String input) {
        int subTaskCharCount = findSubtaskCharCount(input);
        return IntStream.range(0, subTaskCount)
                .mapToObj(i -> createSubtask(accumulator, input, subTaskCharCount, i));
    }

    protected abstract Map<Character, Integer> createAccumulator();

    protected abstract void execute(Stream<Subtask> subtasks);

    private int findSubtaskCharCount(String input) {
        return (int) Math.ceil((double) input.length() / subTaskCount);
    }

    private static Subtask createSubtask(Map<Character,Integer> accumulator, String input, int charCount, int index) {
        int start = index * charCount;
        int end = Math.min((index + 1) * charCount, input.length());
        return new Subtask(accumulator, input, start, end);
    }

    protected static final class Subtask {
        private final Map<Character, Integer> accumulator;
        private final String input;
        private final int start;
        private final int end;

        public Subtask(Map<Character, Integer> accumulator, String input, int start, int end) {
            this.accumulator = accumulator;
            this.input = input;
            this.start = start;
            this.end = end;
        }

        public void execute() {
            IntStream.range(start, end)
                    .map(input::codePointAt)
                    .filter(Character::isLetter)
                    .map(Character::toLowerCase)
                    .forEach(this::accumulate);
        }

        private void accumulate(int codePoint) {
            final Character character = (char) codePoint;
            accumulator.merge(character, 1, Integer::sum);
        }
    }
}
