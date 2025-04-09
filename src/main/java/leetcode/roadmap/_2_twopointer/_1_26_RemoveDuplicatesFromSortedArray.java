package leetcode.roadmap._2_twopointer;

import java.util.Arrays;

public class _1_26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 4, 4, 5, 6, 7, 8};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    //return number of unique elements
    //save order
    //array have to starts with unique elements
    public static int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                l++;
                nums[l] = nums[r];
            }
            r++;
        }

        return l + 1;
    }
}
