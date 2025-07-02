package leetcode.seanprashad_leetcode_patterns.easy;

import leetcode.roadmap._5_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
//        Integer[] nodes = {3,9,20,null,null,15,7};
        Integer[] nodes = {2, null, 3, null, 4, null, 5, null, 6};
        TreeNode root = TreeNode.arrayToTree(nodes);
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
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
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null) {
                    return depth;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return depth;
    }
}
