import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    Node root;

    Tree() {
        this.root = null;
    }

    void addNode(int x) {
        if (root == null) {
            root = new Node(x);
        } else {
            add(root, x);
        }
    }

    private void add(Node node, int x) {
        if (x < node.data) {
            if (node.left == null) {
                node.left = new Node(x);
            } else {
                add(node.left, x);
            }
        } else if (x > node.data) {
            if (node.right == null) {
                node.right = new Node(x);
            } else {
                add(node.right, x);
            }
        }
    }

    List<Integer> sortedLeaves() {
        List<Integer> leaves = new ArrayList<>();
        sortedLeaves(root, leaves);
        return leaves;
    }

    private void sortedLeaves(Node node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.data);
        }
        sortedLeaves(node.left, leaves);
        sortedLeaves(node.right, leaves);
    }
}

public class Main {
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

        List<Integer> leaves = tree.sortedLeaves();
        for (int leaf : leaves) {
            System.out.println(leaf);
        }

        scanner.close();
    }
}

