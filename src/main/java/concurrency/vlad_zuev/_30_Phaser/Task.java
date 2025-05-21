package concurrency.vlad_zuev._30_Phaser;

public abstract class Task {
    private final long id;

    public Task(long id) {
        this.id = id;
    }

    public abstract void perform();

    @Override
    public final String toString() {
        return getClass().getSimpleName() + "[id = " + id + "]";
    }
}
