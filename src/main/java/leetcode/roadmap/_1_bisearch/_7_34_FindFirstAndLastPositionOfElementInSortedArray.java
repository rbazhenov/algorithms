package leetcode.roadmap._1_bisearch;

import java.util.Arrays;

public class _7_34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 1;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] notFound = {-1, -1};
        if (nums.length == 0) {
            return notFound;
        }

        //find max less
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m;
            } else if (nums[m + 1] != target) {
                l = m + 1;
            } else if (nums[m + 1] == target) {
                l = m + 1;
                break;
            }
        }
        if (nums[l] != target) {
            return notFound;
        }
        int maxLess = l;

        //find min bigger
        r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target && nums[m + 1] == target) {
                l = m + 1;
            } else if (nums[m] == target && nums[m + 1] != target) {
                r = m;
                break;
            } else {
                r = m - 1;
            }
        }
        int minBigger = r;

        return new int[]{maxLess, minBigger};
    }
}
