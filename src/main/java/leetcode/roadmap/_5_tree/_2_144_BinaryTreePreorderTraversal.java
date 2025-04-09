package leetcode.roadmap._5_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _2_144_BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Integer[] array = {1, null, 2, null, null, 3, null};
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(preorderTraversalStack(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        preorderTraversal(root, preorder);
        return preorder;
    }

    public static void preorderTraversal(TreeNode root, List<Integer> preorder) {
        if (root == null) {
            return;
        }

        preorder.add(root.val);
        preorderTraversal(root.left, preorder);
        preorderTraversal(root.right, preorder);
    }


    public static List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                preorder.add(root.val);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }

        return preorder;
    }
}
