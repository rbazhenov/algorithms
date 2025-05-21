package concurrency.vlad_zuev._29_Exchanger;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Exchanger;

public abstract class ExchangingTask implements Runnable {
    private final Exchanger<Queue<ExchangedObject>> exchanger;
    private Queue<ExchangedObject> objects;

    public ExchangingTask(Exchanger<Queue<ExchangedObject>> exchanger) {
        this.exchanger = exchanger;
        this.objects = new ArrayDeque<>();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            handler(objects);
            exchange();
        }
    }

    protected abstract void handler(final Queue<ExchangedObject> objects);

    private void exchange() {
        try {
            objects = exchanger.exchange(objects);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
