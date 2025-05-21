package concurrency.vlad_zuev._29_Exchanger;

public final class ExchangedObject {
    private final long id;

    public ExchangedObject(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id = " + id + "]";
    }
}
