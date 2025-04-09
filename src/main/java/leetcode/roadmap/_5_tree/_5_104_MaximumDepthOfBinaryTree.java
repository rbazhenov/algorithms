package leetcode.roadmap._5_tree;

import java.util.LinkedList;
import java.util.Queue;

public class _5_104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(maxDepthQueue(root));
    }

    public static int maxDepthQueue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return depth;
    }

    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
