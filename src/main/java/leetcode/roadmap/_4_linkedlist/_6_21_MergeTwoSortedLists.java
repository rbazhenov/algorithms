package leetcode.roadmap._4_linkedlist;

public class _6_21_MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] nodes1 = {1, 2, 4};
        int[] nodes2 = {1, 3, 4};
        ListNode head1 = ListNode.createHead(nodes1);
        ListNode head2 = ListNode.createHead(nodes2);

        ListNode merged = mergeTwoLists(head1, head2);
        System.out.println(merged);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode current = merged;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }

            current = current.next;
        }

        current.next = list1 != null ? list1 : list2;

        return merged.next;
    }

    public ListNode mergeTwoListsRec(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return (list1 != null) ? list1 : list2;
        }

        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    }
}
