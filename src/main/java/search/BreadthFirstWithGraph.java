package search;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstWithGraph {

    public static void main(String[] args) {
        Node<Integer> start = new Node<>(10);
        Node<Integer> firstNeighbor = new Node<>(2);
        start.connect(firstNeighbor);

        Node<Integer> firstNeighborNeighbor = new Node<>(3);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(start);

        Node<Integer> secondNeighbor = new Node<>(4);
        start.connect(secondNeighbor);

        search(4, firstNeighborNeighbor);
    }

    public static <T> Optional<Node<T>> search(T value, Node<T> start) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.println("Visited node with value: " + currentNode.getValue());
            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                visited.add(currentNode);
                queue.addAll(currentNode.getNeighbors());
                queue.removeAll(visited);
            }
        }

        return Optional.empty();
    }


    static class Node<T> {
        private T value;
        private Set<Node<T>> neighbors;

        public Node(T value) {
            this.value = value;
            this.neighbors = new HashSet<>();
        }

        public void connect(Node<T> node) {
            if (this == node)
                throw new IllegalArgumentException("Can't connect node to itself");
            this.neighbors.add(node);
            node.neighbors.add(this);
        }

        public T getValue() {
            return value;
        }

        public Set<Node<T>> getNeighbors() {
            return neighbors;
        }
    }
}
