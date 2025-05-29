package concurrency.vlad_zuev._32_cuncurrentHashMap;

public class Runner {
    public static void main(String[] args) {
        CounterTestUtil.test(new SingleThreadLetterCounter());
        CounterTestUtil.test(new MultiThreadLetterCounter(5));
    }
}
