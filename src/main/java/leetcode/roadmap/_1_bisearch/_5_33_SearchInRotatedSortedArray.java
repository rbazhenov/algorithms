package leetcode.roadmap._1_bisearch;

public class _5_33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {1, 3};
        int target = 7;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        //find rotated index
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int rotatedIndex = l;
        //find possible target index
        if (l == 0) {
            return biSearch(nums, l, nums.length - 1, target);
        } else if (target >= nums[0]) {
            return biSearch(nums, 0, rotatedIndex - 1, target);
        } else {
            return biSearch(nums, rotatedIndex, nums.length - 1, target);
        }
    }

    private static int biSearch(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        if (nums[l] == target) {
            return l;
        } else {
            return -1;
        }
    }
}
