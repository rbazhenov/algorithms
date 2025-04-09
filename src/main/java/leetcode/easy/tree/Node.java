package leetcode.easy.tree;

public class Node {
    Integer key;
    Node left;
    Node right;
    Integer height;

    public Node() {
    }

    public Node(int key) {
        this.key = key;
    }

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public static Node createNode(Integer val) {
        if (val == null) {
            return null;
        }
        return new Node(val);
    }

    public Integer getVal() {
        return key;
    }

    public void setVal(Integer val) {
        this.key = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getDepth() {
        return height;
    }

    public void setHeight(Integer depth) {
        this.height = depth;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
