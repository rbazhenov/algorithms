package leetcode.roadmap._5_tree;

public class _7_112_PathSum {
    public static void main(String[] args) {
        Integer[] array = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode root = TreeNode.arrayToTree(array);
        int targetSum = 22;

        System.out.println(hasPathSum(root, targetSum));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
