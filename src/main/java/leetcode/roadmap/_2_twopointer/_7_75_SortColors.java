package leetcode.roadmap._2_twopointer;

import java.util.Arrays;

public class _7_75_SortColors {
    public static void main(String[] args) {
        int[] nums = {0, 1};
//        int[] nums = {2,0,2,1,1,0};
//        int[] nums = {0, 0, 1, 0, 1, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int min = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            int midVal = nums[mid];
            if (midVal == 0) {
                swap(nums, mid, min);
                min++;
                mid++;
            } else if (midVal == 1) {
                mid++;
            } else if (midVal == 2) {
                swap(nums, high, mid);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
