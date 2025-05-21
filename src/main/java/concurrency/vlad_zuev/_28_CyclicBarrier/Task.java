package concurrency.vlad_zuev._28_CyclicBarrier;

public abstract class Task {
    private final long id;

    public Task(long id) {
        this.id = id;
    }

    public abstract void perform();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id = " + id + "]";
    }
}
