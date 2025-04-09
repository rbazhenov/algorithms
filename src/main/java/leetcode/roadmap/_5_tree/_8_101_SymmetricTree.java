package leetcode.roadmap._5_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _8_101_SymmetricTree {
    public static void main(String[] args) {
//        Integer[] array = {1, 2, 2, 3, 4, 4, 3};
        Integer[] array = {1, 2, 2, null, 3, null, 3};
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(isSymmetricQueue(root));
    }

    public static boolean isSymmetricQueue(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root.left);
        stack.add(root.right);

        while (!stack.isEmpty()) {
            TreeNode p1 = stack.pop();
            TreeNode p2 = stack.pop();
            if (p1 == null && p2 == null) {
                continue;
            }
            if (p1 == null || p2 == null || p1.val != p2.val) {
                return false;
            }

            stack.add(p1.right);
            stack.add(p2.left);
            stack.add(p1.left);
            stack.add(p2.right);
        }

        return true;
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }
}
