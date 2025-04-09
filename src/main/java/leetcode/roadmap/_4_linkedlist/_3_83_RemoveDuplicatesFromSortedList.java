package leetcode.roadmap._4_linkedlist;

public class _3_83_RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        int[] nodes = {1,1,2,3,3};
        ListNode head = ListNode.createHead(nodes);
        ListNode deletedDuplicates = deleteDuplicates(head);
        System.out.println(deletedDuplicates);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next!= null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}
