package leetcode.roadmap._4_linkedlist;

import java.util.HashSet;
import java.util.Set;

public class _2_141_LinkedListCycle {
    public static void main(String[] args) {
        int[] nodes = {3, 2, 0, -4};
        ListNode head = ListNode.createHead(nodes);
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycleBest(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;
    }
}
