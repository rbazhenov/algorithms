package concurrency.vlad_zuev._29_Exchanger;

import java.util.Queue;
import java.util.concurrent.Exchanger;

public class ConsumingTask extends ExchangingTask {

    public ConsumingTask(Exchanger<Queue<ExchangedObject>> exchanger) {
        super(exchanger);
    }

    @Override
    protected void handler(Queue<ExchangedObject> objects) {
        while (!objects.isEmpty()){
            ExchangedObject object = objects.poll();
            System.out.printf("%s was consumed.\n", object);
        }
        System.out.println("-----------------------------");
    }
}
