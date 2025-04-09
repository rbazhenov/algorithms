package leetcode.roadmap._4_linkedlist;

public class _5_234_PalindromeLinkedList {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 2, 1};
        ListNode head = ListNode.createHead(nodes);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode current = slow;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        while (prev != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }

        return true;
    }
}
