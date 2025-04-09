package leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {
    private Node root;
    private boolean balanced;

    public Tree() {
    }

    public Tree(Node root) {
        this.root = root;
    }

    public static List<Integer> sortValues(Node node) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while (!stack.empty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                result.add(node.getVal());
                node = node.getRight();
            }
        }
        return result;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node addNode(Node node, int val) {
        return addNode(node, val, 1);
    }

    private Node addNode(Node node, int val, int depth) {
        Integer rootVal = node.getVal();
        if (rootVal == null) {
            node.setVal(val);
            node.setHeight(depth);
            return node;
        }

        depth++;
        if (rootVal > val) {
            Node left = node.getLeft();
            if (left == null) {
                left = new Node(val);
                node.setLeft(left);
                node.setHeight(depth);
            } else {
                return addNode(left, val, depth);
            }
        }

        if (rootVal < val) {
            Node right = node.getRight();
            if (right == null) {
                right = new Node(val);
                node.setRight(right);
                node.setHeight(depth);
            } else {
                return addNode(right, val, depth);
            }
        }

        if (rootVal == val) {
            node.setHeight(-1);
        }

        return node;
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
