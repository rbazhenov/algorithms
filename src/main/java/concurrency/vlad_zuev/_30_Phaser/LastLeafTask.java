package concurrency.vlad_zuev._30_Phaser;

import java.util.concurrent.Phaser;

public class LastLeafTask extends AbstractLeafTask {

    public LastLeafTask(long id, long secondDuration, Phaser phaser) {
        super(id, secondDuration, phaser);
    }

    @Override
    protected void onFinish(Phaser phaser) {
        phaser.arriveAndDeregister();
    }
}
