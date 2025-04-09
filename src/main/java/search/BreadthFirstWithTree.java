package search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

/**
 * Поиск в ширину.
 * https://for-each.dev/lessons/b/-java-breadth-first-search
 */
public class BreadthFirstWithTree {
    public static void main(String[] args) {
        Tree<Integer> root = Tree.of(10);
        Tree<Integer> rootFirstChild = root.addChild(2);
        Tree<Integer> depthMostChild = rootFirstChild.addChild(3);
        Tree<Integer> rootSecondChild = root.addChild(4);

        search(4, root);
    }

    public static <T> Optional<Tree<T>> search(T value, Tree<T> root) {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree<T> currentNode = queue.remove();
            System.out.println("Visited node = " + currentNode.getValue());
            if (currentNode.getValue().equals(value)){
                return Optional.of(currentNode);
            } else {
                queue.addAll(currentNode.getChildren());
            }
        }

        return Optional.empty();
    }

    static class Tree<T> {
        private T value;
        private List<Tree<T>> children;

        public Tree(T value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        public static <T> Tree<T> of(T value) {
            return new Tree<>(value);
        }

        public Tree<T> addChild(T value) {
            Tree<T> newChild = new Tree<>(value);
            this.children.add(newChild);
            return newChild;
        }

        public T getValue() {
            return value;
        }

        public List<Tree<T>> getChildren() {
            return children;
        }
    }

}
