package sorokin;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class _2_MultiIterator_2<T> implements Iterator<T> {

    private final Iterator<T>[] iterators;
    private int currentIteratorId = -1;

    public _2_MultiIterator_2(Iterator<T>[] iterators) {
        this.iterators = iterators;
    }


    @Override
    public boolean hasNext() {
        return Arrays.stream(iterators)
                .anyMatch(Iterator::hasNext);
    }

    @Override
    public T next() {
        for (int i = 0; i < iterators.length; i++) {
            Iterator<T> iterator = iterators[i];
            if (iterator.hasNext()) {
                currentIteratorId = i;
                return iterator.next();
            }
        }

        currentIteratorId = -1;
        throw new NoSuchElementException("No element");
    }


    @Override
    public void remove() {
        if (currentIteratorId == -1) {
            throw new NoSuchElementException("No element");
        }

        iterators[currentIteratorId].remove();
    }
}
