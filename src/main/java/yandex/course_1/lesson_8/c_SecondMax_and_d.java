package yandex.course_1.lesson_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class c_SecondMax_and_d {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        for (String s : input) {
            int x = Integer.parseInt(s);
            if (x == 0) {
                List<Integer> sortedNodes = TreeNode.sortValues(tree);
//                System.out.println(sortedNodes.get(sortedNodes.size() - 2));
                sortedNodes.forEach(System.out::println);
            } else {
                tree.addNode(tree, x);
            }
        }
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

        public static List<Integer> sortValues(TreeNode node) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.empty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                } else {
                    node = stack.pop();
                    result.add(node.getVal());
                    node = node.getRight();
                }
            }
            return result;
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
