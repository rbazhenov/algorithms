package leetcode.easy.tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 */
public class _110_BalancedBinaryTree {

    public static void main(String[] args) {
//        Integer[] leafs = {3, 9, 20, null, null, 15, 7};
        Integer[] leafs = {1, 2, 3, 4, 5, 6, null, 8};
        System.out.println(best(create(leafs)));
    }

    public static boolean best(Node root) {
        return bestHeight(root) != -1;
    }

    public static int bestHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int lh = bestHeight(node.left);
        int rh = bestHeight(node.right);

        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) {
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }

    public static Node create(Integer[] leafs) {
        Node root = Node.createNode(leafs[0]);
        Node left = Node.createNode(leafs[1]);
        Node right = Node.createNode(leafs[2]);
        root.left = left;
        root.right = right;

        left.left = Node.createNode(leafs[3]);
        left.right = Node.createNode(leafs[4]);

        right.left = Node.createNode(leafs[5]);
        right.right = Node.createNode(leafs[6]);

        left.left.left = Node.createNode(leafs[7]);

        return root;
    }
}
