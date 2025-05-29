package concurrency.vlad_zuev;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class _35_MyConcurrentStack<T> {
    private final AtomicReference<Node<T>> head = new AtomicReference<>();

    public void push(final T element) {
        while (true) {
            final Node<T> prevHead = head.get();
            final Node<T> newNode = new Node<>(element, prevHead);
            if (head.compareAndSet(prevHead, newNode)) {
                return;
            }
        }
    }

    public Optional<T> pop() {
        while (true) {
            final Node<T> prevHead = head.get();
            if (prevHead == null) {
                return Optional.empty();
            }
            if (head.compareAndSet(prevHead, prevHead.next)) {
                return Optional.of(prevHead.value);
            }
        }
    }

    private static final class Node<T> {
        private final T value;
        private final Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
