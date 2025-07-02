package leetcode.seanprashad_leetcode_patterns.easy;

import leetcode.roadmap._5_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637_AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Integer[] leafs = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.arrayToTree(leafs);
        System.out.println(averageOfLevels(root));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode current = queue.poll();
                sum+= current.getVal();

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
            result.add((double) sum/n);
        }

        return result;
    }
}
