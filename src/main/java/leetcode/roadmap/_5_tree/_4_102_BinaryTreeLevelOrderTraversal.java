package leetcode.roadmap._5_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _4_102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrderQueue(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                arr.add(curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            ans.add(arr);
        }

        return ans;
    }

    public static List<List<Integer>> levelOrderRec(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        levelOrderHelper(output, root, 0);
        return output;
    }

    public static void levelOrderHelper(List<List<Integer>> output, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level >= output.size()) {
            output.add(new ArrayList<>());
        }
        output.get(level).add(root.val);
        levelOrderHelper(output, root.left, level + 1);
        levelOrderHelper(output, root.right, level + 1);
    }

    //my bad, but works
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> levels = new ArrayDeque<>();

        queue.add(root);
        levels.add(0);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            Integer level = levels.poll();

            addWithLevel(ans, curr.val, level);

            int newLevel = level + 1;
            if (curr.left != null) {
                queue.add(curr.left);
                levels.add(newLevel);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                levels.add(newLevel);
            }
        }

        return ans;
    }

    private static void addWithLevel(List<List<Integer>> ans, int value, int level) {
        if (level < ans.size() && ans.get(level) != null) {
            ans.get(level).add(value);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(value);
            ans.add(level, list);
        }
    }

}
