package leetcode.easy.tree;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class _226_InvertBinaryTree {

    public static void main(String[] args) {
        Node x = invertTree(new Node());
        System.out.println(x);
    }

    //поменьше кода
    public static Node invertTree(Node root) {
        if (root == null) {
            return null;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    //my best
    public static Node invertTreeMy(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return new Node(root.key, null, null);
        }
        if (root.left == null) {
            return new Node(root.key, invertTreeMy(root.right), null);
        }
        if (root.right == null) {
            return new Node(root.key, null, invertTreeMy(root.left));
        }

        return new Node(root.key, invertTreeMy(root.right), invertTreeMy(root.left));
    }


    public Node create(Integer[] leafs) {
        Node left = new Node(leafs[1]);
        Node right = new Node(leafs[2]);
        Node root = new Node(leafs[0], left, right);

        left.left = new Node(leafs[3]);
        left.right = new Node(leafs[4]);

        right.left = new Node(leafs[5]);
        right.right = new Node(leafs[6]);

        return root;
    }

}
