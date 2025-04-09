package leetcode.roadmap._4_linkedlist;

public class _9_2_AddTwoNumbers {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};

        ListNode l1 = ListNode.createHead(nums1);
        ListNode l2 = ListNode.createHead(nums2);
        ListNode ans = addTwoNumbers(l1, l2);
        System.out.println(ans);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode temp = ans;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = l1 != null ? l1.val : 0;
            int digit2 = l2 != null ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int last = sum % 10;
            carry = sum / 10;

            temp.next = new ListNode(last);
            temp = temp.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        temp.next = null;
        ans = ans.next;
        return ans;
    }
}
