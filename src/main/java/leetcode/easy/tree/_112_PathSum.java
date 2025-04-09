package leetcode.easy.tree;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * <p>
 * A leaf is a node with no children.
 */
public class _112_PathSum {

    public static void main(String[] args) {
        Integer[] leafs = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
//        Integer[] leafs = {1,2,3};
        Node root = new _112_PathSum().create(leafs);
        int targetSum = 22;
//        int targetSum = 4;
        System.out.println(hasPathSum(root, targetSum));
    }

    public static boolean hasPathSum(Node root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.key;
        }

        return hasPathSum(root.left, targetSum - root.key) ||
                hasPathSum(root.right, targetSum - root.key);
    }


    public Node create(Integer[] leafs) {
        Node left = new Node(leafs[1]);
        Node right = new Node(leafs[2]);
        Node root = new Node(leafs[0], left, right);

        left.left = new Node(11, new Node(7), new Node(2));
        left.right = null;

        right.left = new Node(13);
        right.right = new Node(4, null, new Node(1));

        return root;
    }

}
