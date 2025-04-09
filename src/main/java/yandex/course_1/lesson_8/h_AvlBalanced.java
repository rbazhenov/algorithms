package yandex.course_1.lesson_8;

import java.util.Scanner;

public class h_AvlBalanced {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        for (String s : input) {
            int x = Integer.parseInt(s);
            if (x != 0) {
                tree.addNode(x);
            }
        }

        boolean isAvl = tree.isBalanced();
        System.out.println(isAvl ? "YES" : "NO");
    }

    private static class Tree {
        Node root;
        boolean balanced;

        public Tree() {
        }

        public void addNode(int key) {
            if (root == null) {
                root = new Node(key);
            } else {
                addNode(root, key);
            }
        }

        private void addNode(Node node, int key) {
            if (node.key > key) {
                Node left = node.left;
                if (left == null) {
                    left = new Node(key);
                    node.left = left;
                } else {
                    addNode(left, key);
                }
            }

            if (node.key < key) {
                Node right = node.right;
                if (right == null) {
                    right = new Node(key);
                    node.right = right;
                } else {
                    addNode(right, key);
                }
            }
        }

        public boolean isBalanced() {
            balanced = true;
            height(root);
            return balanced;
        }

        public int height(Node node) {
            if (node == null) {
                return 0;
            }
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            balanced = balanced && Math.abs(leftHeight - rightHeight) < 2;
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    private static class Node {
        Integer key;
        Node left;
        Node right;

        public Node(Integer key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
