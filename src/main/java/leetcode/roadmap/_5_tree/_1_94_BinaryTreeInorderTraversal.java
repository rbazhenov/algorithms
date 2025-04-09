package leetcode.roadmap._5_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class _1_94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Integer[] array = {1, null, 2, null, null, 3, null};
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(inorderTraversalRec(root));
    }

    public static List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversalRec(root, inorder);
        return inorder;
    }

    public static void inorderTraversalRec(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }

        inorderTraversalRec(root.left, inorder);
        inorder.add(root.val);
        inorderTraversalRec(root.right, inorder);
    }


    public static List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            inorder.add(root.val);
            root = root.right;
        }

        return inorder;
    }
}
