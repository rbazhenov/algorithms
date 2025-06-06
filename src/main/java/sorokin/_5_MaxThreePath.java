package sorokin;

import leetcode.roadmap._5_tree.TreeNode;

/**
 * На входе бинарное дерево.
 * Путь идёт снизу вверх до какой-то вершины. Потом если выгодно, то сворачивает к потомку.
 */
public class _5_MaxThreePath {

    public static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
//        Integer[] nodes = {-10, 9, 20, null, null, 15, -100};
//        Integer[] nodes = {1, 2, 3};
        Integer[] nodes = {-10, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.arrayToTree(nodes);
        System.out.println(getMaxThreePath(root));
    }

    public static int getMaxThreePath(TreeNode root) {
        getMaxStraightPath(root);
        return result;
    }

    //Возвращает максимально прямой результат снизу вверх
    public static int getMaxStraightPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxL = getMaxStraightPath(root.getLeft());
        int maxR = getMaxStraightPath(root.getRight());

        result = Math.max(result, maxL + root.getVal() + maxR);
        return Math.max(0, Math.max(maxL, maxR) + root.getVal());
    }
}
