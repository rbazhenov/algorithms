package concurrency.vlad_zuev._29_Exchanger;

import java.util.concurrent.TimeUnit;

public final class ExchangedObjectFactory {
    private long nextId;

    public ExchangedObject create() {
        try {
            TimeUnit.SECONDS.sleep(2);
            return new ExchangedObject(nextId++);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
