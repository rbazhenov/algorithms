package concurrency.vlad_zuev._19_boundedbuffer;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public final class BoundedBuffer<T> {
    private final T[] elements;
    private final Lock lock;
    private final Condition notFullCondition;
    private final Condition notEmptyCondition;
    private int size;

    @SuppressWarnings("unchecked")
    public BoundedBuffer(final int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.lock = new ReentrantLock();
        this.notFullCondition = this.lock.newCondition();
        this.notEmptyCondition = this.lock.newCondition();
    }

    public boolean isFull() {
        this.lock.lock();
        try {
            return this.size == elements.length;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isEmpty() {
        this.lock.lock();
        try {
            return this.size == 0;
        } finally {
            this.lock.unlock();
        }
    }

    public void put(final T element) {
        this.lock.lock();
        try {
            while (this.isFull()) {
                this.notFullCondition.await();
            }
            this.elements[this.size] = element;
            this.size++;
            System.out.printf("%s was put in buffer. Result buffer: %s%n", element, this);
            this.notEmptyCondition.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            this.lock.unlock();
        }

    }

    public T take() {
        this.lock.lock();
        try {
            while (this.isEmpty()) {
                this.notEmptyCondition.await();
            }
            final T result = this.elements[this.size - 1];
            this.elements[this.size - 1] = null;
            this.size--;
            System.out.printf("%s was taken from buffer. Result buffer: %s%n", result, this);
            this.notFullCondition.signal();
            return result;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public String toString() {
        this.lock.lock();
        try {
            return "{" +
                    Arrays.stream(this.elements, 0, this.size)
                            .map(Object::toString)
                            .collect(Collectors.joining(","))
                    + "}";
        } finally {
            this.lock.unlock();
        }
    }
}
