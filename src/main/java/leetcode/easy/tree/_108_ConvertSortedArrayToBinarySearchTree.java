package leetcode.easy.tree;

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 */
public class _108_ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
//        int[] nums = {-10, -3, 0, 5, 9};
//        int[] nums = {3, 5, 8};
        int[] nums = {-1, 0, 1, 2};
        Node res = sortedArrayToBST(nums);
        System.out.println(res);
        /**
         * Input: nums = [-10,-3,0,5,9]
         * Output: [0,-3,9,-10,null,5]
         * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
         */
    }

    public static Node best(int[] nums) {
        return best(nums, 0, nums.length - 1);
    }

    public static Node best(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = (l + r) / 2;
        return new Node(nums[m], best(nums, l, m - 1), best(nums, m + 1, r));
    }

    public static Node sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return new Node();
        }

        if (nums.length == 1) {
            return new Node(nums[0]);
        }

        int mid = nums.length / 2;

        if (mid == 1) {
            Node rightNode = nums.length == 3 ? new Node(nums[2]) : null;
            return new Node(nums[1], new Node(nums[0]), rightNode);
        }

        int[] left = new int[mid];
        System.arraycopy(nums, 0, left, 0, mid);

        int rightSize = nums.length % 2 == 0 ? nums.length - 1 - mid : mid;
        int[] right = new int[rightSize];
        System.arraycopy(nums, mid + 1, right, 0, rightSize);

        return new Node(nums[mid], sortedArrayToBST(left), sortedArrayToBST(right));
    }

}
