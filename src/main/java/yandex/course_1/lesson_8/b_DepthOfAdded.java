package yandex.course_1.lesson_8;

import java.util.Scanner;

public class b_DepthOfAdded {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        for (String s : input) {
            int x = Integer.parseInt(s);
            if (x != 0) {
                Integer depth = tree.addNode(tree, x).getDepth();
                System.out.print(depth == -1 ? "" : depth + " ");
            }
        }
    }

    private static class TreeNode {
        private Integer val;
        private TreeNode left;
        private TreeNode right;
        private Integer depth;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public Integer getDepth() {
            return depth;
        }

        public void setDepth(Integer depth) {
            this.depth = depth;
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

        public TreeNode addNode(TreeNode node, int val) {
            return addNode(node, val, 1);
        }

        private TreeNode addNode(TreeNode node, int val, int depth) {
            Integer rootVal = node.getVal();
            if (rootVal == null) {
                node.setVal(val);
                node.setDepth(depth);
                return node;
            }

            depth++;
            if (rootVal > val) {
                TreeNode left = node.getLeft();
                if (left == null) {
                    left = new TreeNode(val);
                    node.setLeft(left);
                    node.setDepth(depth);
                } else {
                    return addNode(left, val, depth);
                }
            }

            if (rootVal < val) {
                TreeNode right = node.getRight();
                if (right == null) {
                    right = new TreeNode(val);
                    node.setRight(right);
                    node.setDepth(depth);
                } else {
                    return addNode(right, val, depth);
                }
            }

            if (rootVal == val) {
                node.setDepth(-1);
            }

            return node;
        }
    }
}

