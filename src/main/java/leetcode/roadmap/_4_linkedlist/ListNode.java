package leetcode.roadmap._4_linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createWithEnd(int[] nodes, ListNode end) {
        if (nodes.length == 0) {
            return null;
        }
        ListNode root = new ListNode(nodes[0]);
        ListNode current = root;
        for (int i = 1; i < nodes.length; i++) {
            ListNode newNode = new ListNode(nodes[i]);
            current.next = newNode;
            current = newNode;
        }

        if (end != null) {
            current.next = end;
        }

        return root;
    }

    public static ListNode createHead(int[] nodes) {
        return createWithEnd(nodes, null);
    }

    @Override
    public String toString() {
        ListNode curr = this;
        StringBuilder builder = new StringBuilder();
        while (curr != null) {
            builder.append(curr.val);
            builder.append("->");
            curr = curr.next;
        }
        return builder.toString();
    }
}
