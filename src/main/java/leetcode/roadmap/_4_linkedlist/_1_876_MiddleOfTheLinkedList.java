package leetcode.roadmap._4_linkedlist;

import static leetcode.roadmap._4_linkedlist.ListNode.createHead;

public class _1_876_MiddleOfTheLinkedList {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5,6};
        ListNode head = createHead(nodes);
        ListNode middleNode = middleNodeBest(head);
        System.out.println(middleNode);
    }

    public static ListNode middleNodeBest(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current.next != null) {
            size++;
            current = current.next;
        }

        int middle = size % 2 == 0 ? size / 2 : size / 2 + 1;

        ListNode middleNode = head;
        for (int i = 0; i < middle; i++) {
            middleNode = middleNode.next;
        }

        return middleNode;
    }
}
