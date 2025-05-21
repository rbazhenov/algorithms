package concurrency.vlad_zuev._25_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenNumberGenerator {

    private static final int GENERATION_DELTA = 2;

    private final AtomicInteger value = new AtomicInteger();

    public int generate() {
        return value.getAndAdd(GENERATION_DELTA);
    }

    public int getValue() {
        return value.intValue();
    }
}
