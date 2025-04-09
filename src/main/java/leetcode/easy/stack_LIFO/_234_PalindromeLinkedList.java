package leetcode.easy.stack_LIFO;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
public class _234_PalindromeLinkedList {

    public static void main(String[] args) {
        _234_PalindromeLinkedList obj = new _234_PalindromeLinkedList();
        int[] arr = {1, 2, 2, 1};
//        int[] arr = {1, 1, 2, 1};
//        int[] arr = {1,0,3,4,0,1};
        ListNode root = obj.create(arr);
        System.out.println(isPalindromeFirst(root));
    }

    //my first try
    public static boolean isPalindromeFirst(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        while (head != null) {
            deque.add(head.val);
            head = head.next;
        }

        int size = deque.size();
        for (int i = 0; i < size / 2; i++) {
            Integer first = deque.removeFirst();
            Integer last = deque.removeLast();
            if (first != last) {
                return false;
            }
        }

        return true;
    }

    public ListNode create(int[] arr) {
        ListNode current = arr.length > 1 ? new ListNode() : null;
        ListNode root = new ListNode(arr[0], current);
        for (int i = 2; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            current.next = temp;
            current = temp;
        }

        return root;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            String nextStr = next != null ? ", " + next : "";
            return val + nextStr;
        }
    }
}
