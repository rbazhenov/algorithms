package leetcode.easy.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the root of a binary search tree and an integer k,
 * return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
 */
public class _653_TwoSumIVInputIsBST {

    public static void main(String[] args) {
        Integer[] root = {5, 3, 6, 2, 4, null, 7};
        int k = 9;
        System.out.println(findTarget(create(root), k));
    }

    public static boolean findTarget(Node root, int k) {
        return findTargetWithSet(root, k, new HashSet<>());
    }

    public static boolean findTargetWithSet(Node root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.key)) {
            return true;
        } else {
            set.add(root.key);
        }

        return findTargetWithSet(root.left, k, set) || findTargetWithSet(root.right, k, set);
    }

    public static Node create(Integer[] leafs) {
        Node left = new Node(leafs[1]);
        Node right = new Node(leafs[2]);
        Node root = new Node(leafs[0], left, right);

        left.left = new Node(leafs[3]);
        left.right = new Node(leafs[4]);

        right.left = null;
        right.right = new Node(leafs[6]);

        return root;
    }
}
