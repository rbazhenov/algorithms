package leetcode.roadmap._4_linkedlist;

public class _8_237_DeleteNodeInLinkedList {
    public static void main(String[] args) {
        int[] nums = {5, 1, 9};
        ListNode node = ListNode.createHead(nums);
        deleteNode(node);
        System.out.println(node);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
