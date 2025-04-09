package leetcode.easy.tree;

import java.util.Objects;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class _100_SameTree {

    public static void main(String[] args) {
        Integer[] p = {1, 2, 3};
        Integer[] q = {1, 2, 3};
        Node pTree = new _100_SameTree().create(p);
        Node qTree = new _100_SameTree().create(q);
        System.out.println(isSameTree(pTree, qTree));
    }

    public static boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && Objects.equals(p.key, q.key)) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }

    public Node create(Integer[] leafs) {
        return new Node(leafs[0], new Node(leafs[1]), new Node(leafs[2]));
    }
}
