package concurrency.vlad_zuev._29_Exchanger;

import java.util.Queue;
import java.util.concurrent.Exchanger;
import java.util.stream.IntStream;

public class ProducingTask extends ExchangingTask {
    private final ExchangedObjectFactory objectFactory;
    private final int producedObjectCount;

    public ProducingTask(Exchanger<Queue<ExchangedObject>> exchanger, ExchangedObjectFactory objectFactory,
                         int producedObjectCount) {
        super(exchanger);
        this.objectFactory = objectFactory;
        this.producedObjectCount = producedObjectCount;
    }

    @Override
    protected void handler(Queue<ExchangedObject> objects) {
        IntStream.range(0, producedObjectCount)
                .mapToObj(i -> objectFactory.create())
                .peek(object -> System.out.printf("%s is being produced.\n", object))
                .forEach(objects::add);
    }
}
