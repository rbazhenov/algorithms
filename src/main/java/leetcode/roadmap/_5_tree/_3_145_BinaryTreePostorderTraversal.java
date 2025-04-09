package leetcode.roadmap._5_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _3_145_BinaryTreePostorderTraversal {
    public static void main(String[] args) {
//        Integer[] array = {1, null, 2, null, null, 3, null};
        Integer[] array = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, null, null,9};
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(postorderTraversalStack(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        postorderTraversal(root, postorder);
        return postorder;
    }

    public static void postorderTraversal(TreeNode root, List<Integer> postorder) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left, postorder);
        postorderTraversal(root.right, postorder);
        postorder.add(root.val);
    }

    public static List<Integer> postorderTraversalStack(TreeNode root) {
        LinkedList<Integer> postorder = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                postorder.addFirst(root.val); // Reverse the process of preorder
                root = root.right; // Reverse the process of preorder
            }
            root = stack.pop();
            root = root.left; // Reverse the process of preorder
        }

        return postorder;
    }
}
