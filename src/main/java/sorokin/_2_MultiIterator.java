package sorokin;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class _2_MultiIterator<T> implements Iterator<T> {

    private final Iterator<T> a;
    private final Iterator<T> b;
    private int currentIteratorId = -1;

    public _2_MultiIterator(Iterator<T> a, Iterator<T> b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public boolean hasNext() {
        return a.hasNext() || b.hasNext();
    }

    @Override
    public T next() {
        if (a.hasNext()) {
            currentIteratorId = 0;
            return a.next();
        }

        currentIteratorId = 1;
        return b.next();
    }


    @Override
    public void remove() {
        if (currentIteratorId == -1) {
            throw new NoSuchElementException("No element");
        }

        if (currentIteratorId == 0) {
            a.remove();
        }

        b.remove();
    }
}
