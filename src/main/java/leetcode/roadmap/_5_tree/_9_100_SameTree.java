package leetcode.roadmap._5_tree;

import java.util.Stack;

public class _9_100_SameTree {
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3};
        TreeNode root1 = TreeNode.arrayToTree(array1);
        TreeNode root2 = TreeNode.arrayToTree(array2);
        System.out.println(isSameTree(root1, root2));
    }

    public static boolean isSameTreeStack(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(p);
        stack.add(q);
        while (!stack.isEmpty()) {
            TreeNode popP = stack.pop();
            TreeNode popQ = stack.pop();

            if (popP == null && popQ == null) {
                continue;
            }

            if (popP == null || popQ == null || popP.val != popQ.val) {
                return false;
            }

            stack.add(popP.left);
            stack.add(popQ.left);
            stack.add(popP.right);
            stack.add(popQ.right);
        }

        return true;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
