package concurrency.vlad_zuev._30_Phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public abstract class AbstractLeafTask extends Task {
    private final long secondDuration;
    private final Phaser phaser;

    public AbstractLeafTask(long id, long secondDuration, Phaser phaser) {
        super(id);
        this.secondDuration = secondDuration;
        this.phaser = phaser;
    }

    @Override
    public void perform() {
        try {
            System.out.printf("%s is starting.\n", this);
            TimeUnit.SECONDS.sleep(secondDuration);
            System.out.printf("%s has finished.\n", this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            onFinish(phaser);
        }
    }

    protected abstract void onFinish(final Phaser phaser);
}
