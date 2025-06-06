package leetcode.roadmap._4_linkedlist;

import java.util.Stack;

public class _4_206_ReverseLinkedList {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createHead(nodes);
        ListNode reversed = reverseListBest(head);
        System.out.println(reversed);
    }

    public static ListNode reverseListBest(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;

        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }

        ListNode reversed = stack.pop();
        temp = reversed;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
            temp.next = null;
        }

        return reversed;
    }
}
