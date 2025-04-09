package leetcode.easy.tree;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * <p>
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Design an algorithm that runs in less than O(n) time complexity.
 */
public class _222_CountCompleteTreeNodes {

    public static void main(String[] args) {
        Integer[] leafs = {1, 2, 3, 4, 5, 6, 7};

        Node root = new _222_CountCompleteTreeNodes().create(leafs);
        System.out.println(countNodes(root));
    }

    //Если Высота левой части и правой одинаковы, то количество узлов вычисляется по формуле
    //2^height(1<<height) -1
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1;
        }

        Node left = root;
        int lh = 0;
        while (left != null) {
            lh++;
            left = left.left;
        }

        Node right = root;
        int rh = 0;
        while (right != null) {
            rh++;
            right = right.right;
        }

        if (rh == lh) {
            int result = (1 << lh) - 1;
            return result;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public Node create(Integer[] leafs) {
        Node left = new Node(leafs[1], new Node(leafs[3]), new Node(leafs[4]));
        Node right = new Node(leafs[2], new Node(leafs[5]), new Node(leafs[6]));
        return new Node(leafs[0], left, right);
    }
}
