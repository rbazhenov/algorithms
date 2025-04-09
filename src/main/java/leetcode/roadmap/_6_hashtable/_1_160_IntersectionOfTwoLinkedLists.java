package leetcode.roadmap._6_hashtable;

import leetcode.roadmap._4_linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _1_160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        int[] nodesA = {4, 1};
        int[] nodesB = {5, 6, 1};
        int[] intersection = {8, 4, 5};

        ListNode end = ListNode.createHead(intersection);
        ListNode headA = ListNode.createWithEnd(nodesA, end);
        ListNode headB = ListNode.createWithEnd(nodesB, end);

        System.out.println(getIntersectionNode(headA, headB));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }
        while (tempB != null) {
            if (set.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }

        return null;
    }
}
