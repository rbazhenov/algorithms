package concurrency.vlad_zuev._28_CyclicBarrier;

import java.util.List;

public class MainTask extends CompositeTask<Subtask> {

    public MainTask(long id, List<Subtask> subtasks) {
        super(id, subtasks);
    }

    @Override
    protected void perform(Subtask subtask) {
        new Thread(subtask::perform).start();
    }
}
