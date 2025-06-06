package leetcode.seanprashad_leetcode_patterns.easy;

import leetcode.roadmap._4_linkedlist.ListNode;

public class _203_RemoveLinkedListElements {
    public static void main(String[] args) {
        int[] nodes = {1,2,6,3,4,5,6};
        int val = 6;
        ListNode head = ListNode.createHead(nodes);
        System.out.println(removeElements(head, val));
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(0, head);
        ListNode dummy = ans;
        while (dummy != null) {
            while (dummy.next != null && dummy.next.val == val){
                dummy.next = dummy.next.next;
            }
            dummy = dummy.next;
        }

        return ans.next;
    }
}
