package leetcode.seanprashad_leetcode_patterns.easy;

public class _704_BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l] == target ? l : -1;
    }
}
