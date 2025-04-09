package leetcode.roadmap._4_linkedlist;

public class _10_148_SortList {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3};
        ListNode head = ListNode.createHead(nums);
        ListNode sorted = mergeSort(head);
        System.out.println(sorted);
    }

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode second = split(head);
        head = mergeSort(head);
        second = mergeSort(second);

        return merge(head, second);
    }

    private static ListNode merge(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        if (first.val < second.val) {
            first.next = merge(first.next, second);
            return first;
        } else {
            second.next = merge(first, second.next);
            return second;
        }
    }

    private static ListNode split(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) {
                slow = slow.next;
            }
        }

        ListNode second = slow.next;
        slow.next = null;
        return second;
    }
}
