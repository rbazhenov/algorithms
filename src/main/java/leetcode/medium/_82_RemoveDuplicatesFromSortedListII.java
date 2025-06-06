package leetcode.medium;

import leetcode.roadmap._4_linkedlist.ListNode;

public class _82_RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = ListNode.createHead(nums);
        System.out.println(head);
        System.out.println(deleteDuplicates(head));
    }

    //delete node if it has duplicate
    //1233445 ->125
    //1 1 1 2 3 3 4 4 5
    //      l r
    //1 2 3 3
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = new ListNode(0);
        res.next = head;

        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int duplicate = cur.next.val;
                while (cur.next != null && cur.next.val == duplicate) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return res.next;
    }
}
