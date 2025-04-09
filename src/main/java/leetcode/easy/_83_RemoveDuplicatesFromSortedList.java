package leetcode.easy;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 */
public class _83_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
//        int[] arr = {1, 1, 2};
        int[] arr = {1, 1, 2, 3, 3};
        ListNode listNode = new _83_RemoveDuplicatesFromSortedList().create(arr);
        System.out.println(deleteDuplicates(listNode));
    }

    //shorter code
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return res;
    }

    //my best
    public static ListNode deleteDuplicatesMy(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newList = new ListNode(head.val);
        ListNode temp = newList;
        int current = head.val;

        while (head.next != null) {
            int nextVal = head.next.val;
            if (current != nextVal) {
                temp.next = new ListNode(nextVal);
                temp = temp.next;

                current = nextVal;
            }

            head.next = head.next.next;
        }

        return newList;
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


    public static class ListNode {
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
