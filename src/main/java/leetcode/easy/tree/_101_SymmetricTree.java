package leetcode.easy.tree;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class _101_SymmetricTree {

    public static void main(String[] args) {
//        Integer[] leafs = {1, 2, 2, 3, 4, 4, 3};
        Integer[] leafs = {1, 2, 3};
//        Integer[] leafs = {1, 2, 2, null, 3, null, 3};
        Node root = new _101_SymmetricTree().create(leafs);
        System.out.println(isSymmetric(root));
    }

    //i'm the best
    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.key != right.key) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public Node create(Integer[] leafs) {
        Node left = new Node(leafs[1]);
        Node right = new Node(leafs[2]);
        Node root = new Node(leafs[0], left, right);

//        left.left = new TreeNode(leafs[3]);
//        left.right = new TreeNode(leafs[4]);
//
//        right.left = new TreeNode(leafs[5]);
//        right.right = new TreeNode(leafs[6]);

        return root;
    }

}
