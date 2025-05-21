package concurrency.vlad_zuev._30_Phaser;

import java.util.concurrent.Phaser;

public class LeafTask extends AbstractLeafTask {

    public LeafTask(long id, long secondDuration, Phaser phaser) {
        super(id, secondDuration, phaser);
    }

    @Override
    protected void onFinish(Phaser phaser) {
        phaser.arriveAndAwaitAdvance();
    }
}
