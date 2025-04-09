package yandex.course_1.lesson_8;

import java.util.Scanner;

public class a_TreeHeight {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        for (String s : input) {
            int x = Integer.parseInt(s);
            if (x == 0) {
                System.out.println(TreeNode.maxDepth(tree));
            } else {
                tree.addNode(tree, x);
            }
        }

        scanner.close();
    }

    private static class TreeNode {
        private Integer val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public static int maxDepth(TreeNode node) {
            return node == null ? 0 : 1 + Math.max(maxDepth(node.getLeft()), maxDepth(node.getRight()));
        }

        public Integer getVal() {
            return this.val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public void addNode(TreeNode node, int val) {
            Integer rootVal = node.getVal();
            if (rootVal == null) {
                node.setVal(val);
                return;
            }

            if (rootVal == val) {
                return;
            }

            if (rootVal > val) {
                TreeNode left = node.getLeft();
                if (left == null) {
                    left = new TreeNode(val);
                    node.setLeft(left);
                } else {
                    addNode(left, val);
                }
            }

            if (rootVal < val) {
                TreeNode right = node.getRight();
                if (right == null) {
                    right = new TreeNode(val);
                    node.setRight(right);
                } else {
                    addNode(right, val);
                }
            }
        }
    }
}