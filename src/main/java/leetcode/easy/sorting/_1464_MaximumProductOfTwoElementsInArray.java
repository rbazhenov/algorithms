package leetcode.easy.sorting;

import java.util.Arrays;

/**
 * Given the array of integers nums, you will choose two different indices i and j of that array.
 * Return the maximum value of (nums[i]-1)*(nums[j]-1).
 */
public class _1464_MaximumProductOfTwoElementsInArray {

    public static void main(String[] args) {
        int[] nums = {1,5,4,5};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
