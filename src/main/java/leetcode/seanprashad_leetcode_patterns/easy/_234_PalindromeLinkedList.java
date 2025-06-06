package leetcode.seanprashad_leetcode_patterns.easy;

import leetcode.roadmap._4_linkedlist.ListNode;

public class _234_PalindromeLinkedList {
    public static void main(String[] args) {
        int[] nodes = {1,2,2,1};
        ListNode head = ListNode.createHead(nodes);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        while (prev != null) {
            if (head.val != prev.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }

        return true;
    }
}
