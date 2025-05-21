package concurrency.vlad_zuev._30_Phaser;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Phaser;

public class Runner {
    public static void main(String[] args) {
        final Phaser phaser = new Phaser(3){
            @Override
            protected boolean onAdvance(int phase, int parties) {
                System.out.println();
                System.out.printf("Thread: %s\n", Thread.currentThread().getName());
                System.out.printf("Current phase: %d\n", phase);
                System.out.printf("Current parties: %d\n", parties);
                System.out.println();

                return super.onAdvance(phase, parties);
            }
        };

        final LeafTask firstLeafTask = new LeafTask(0, 5, phaser);
        final LeafTask secondLeafTask = new LeafTask(1, 3, phaser);
        final LastLeafTask firstLastLeafTask = new LastLeafTask(0, 1, phaser);
        final Subtask firstSubtask = new Subtask(0, List.of(firstLeafTask, secondLeafTask), firstLastLeafTask);

        final LeafTask thirdtLeafTask = new LeafTask(2, 6, phaser);
        final LastLeafTask secondLastLeafTask = new LastLeafTask(1, 4, phaser);
        final Subtask secondSubtask = new Subtask(1, List.of(thirdtLeafTask), secondLastLeafTask);

        final LastLeafTask thirdLastLeafTask = new LastLeafTask(2, 7, phaser);
        final Subtask thirdSubtask = new Subtask(2, Collections.emptyList(), thirdLastLeafTask);

        final MainTask mainTask = new MainTask(0, List.of(firstSubtask, secondSubtask, thirdSubtask));
        mainTask.perform();
    }
}
