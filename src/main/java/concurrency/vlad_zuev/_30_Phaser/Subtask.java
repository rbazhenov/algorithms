package concurrency.vlad_zuev._30_Phaser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Subtask extends CompositeTask<AbstractLeafTask> {

    public Subtask(long id, List<LeafTask> leafTasks, LastLeafTask lastLeafTask) {
        super(id, concat(leafTasks, lastLeafTask));
    }

    private static List<AbstractLeafTask> concat(final List<LeafTask> leafTasks, final LastLeafTask lastLeafTask) {
        return Stream.concat(
                leafTasks.stream(),
                Stream.of(lastLeafTask)
        ).collect(Collectors.toList());
    }

    @Override
    protected void perform(AbstractLeafTask leafTask) {
        leafTask.perform();
    }
}
