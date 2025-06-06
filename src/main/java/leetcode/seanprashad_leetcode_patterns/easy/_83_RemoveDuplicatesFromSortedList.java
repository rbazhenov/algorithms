package leetcode.seanprashad_leetcode_patterns.easy;

import leetcode.roadmap._4_linkedlist.ListNode;

public class _83_RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        int[] nodes = {1,1,1};
        ListNode head = ListNode.createHead(nodes);
        System.out.println(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}
