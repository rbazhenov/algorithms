package leetcode.easy.tree;


/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class _104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Integer[] leafs = {3, 9, 20, null, null, 15, 7};
        Node treeNode = new _104_MaximumDepthOfBinaryTree().create(leafs);
        System.out.println(maxDepth(treeNode));
    }

    public static int maxDepth(Node root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public Node create(Integer[] leafs) {
        Node left = new Node(leafs[1]);
        Node right = new Node(leafs[2]);
        Node root = new Node(leafs[0], left, right);

        left.left = new Node();
        left.right = new Node();

        right.left = new Node(leafs[5]);
        right.right = new Node(leafs[6]);

        return root;
    }

}
