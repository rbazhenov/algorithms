package leetcode.easy;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 */
public class _21_MergeTwoSortedList {

    public static void main(String[] args) {
        _21_MergeTwoSortedList clazz = new _21_MergeTwoSortedList();

        ListNode list1 = clazz.create(new int[]{-9, 3});
        ListNode list2 = clazz.create(new int[]{5, 7});

        ListNode res = clazz.mergeTwoLists(list1, list2);
        System.out.println(res);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return new ListNode(list2.val, list2.next);
        }
        if (list2 == null) {
            return new ListNode(list1.val, list1.next);
        }

        if (list1.val < list2.val) {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        }
        if (list1.val > list2.val) {
            return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        }

        //list1.val == list2.val
        return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
    }

    public ListNode create(int[] arr) {
        ListNode current = arr.length > 1 ? new ListNode() : null;
        ListNode root = new ListNode(arr[0], current);
        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            if (root.next.val == 0) {
                root.next = temp;
            }
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
