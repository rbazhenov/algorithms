package leetcode.roadmap._5_tree;

import java.util.LinkedList;
import java.util.Queue;

public class _7_112_PathSum {
    public static void main(String[] args) {
        Integer[] array = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode root = TreeNode.arrayToTree(array);
        int targetSum = 22;

        System.out.println(hasPathSumRec(root, targetSum));
    }

    public static boolean hasPathSumRec(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sum = new LinkedList<>();

        queue.add(root);
        sum.add(root.val);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            int currSum = sum.poll();

            if (currNode.left == null && currNode.right == null && targetSum == currSum) {
                return true;
            }

            if (currNode.left != null) {
                queue.add(currNode.left);
                sum.add(currSum + currNode.left.val);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
                sum.add(currSum + currNode.right.val);
            }
        }

        return false;
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
