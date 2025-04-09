package leetcode.easy.sorting;

import java.util.Arrays;

/**
 * You have an array of floating point numbers averages which is initially empty.
 * You are given an array nums of n integers where n is even.
 * <p>
 * You repeat the following procedure n / 2 times:
 * <p>
 * Remove the smallest element, minElement, and the largest element maxElement, from nums.
 * Add (minElement + maxElement) / 2 to averages.
 * Return the minimum element in averages.
 */
public class _3194_MinimumAverageOfSmallestAndLargestElements {

    public static void main(String[] args) {
        int[] nums = {7, 8, 3, 4, 15, 13, 4, 1};
        System.out.println(best(nums));
    }

    //без вспомагательного массива
    public static double best(int[] nums) {
        Arrays.sort(nums);

        int a = 0;
        int b = nums.length - 1;
        double res = Double.MAX_VALUE;

        while (a < b) {
            res = Math.min(res, (nums[a++] + nums[b--]) / 2D);
        }

        return res;
    }

    public static double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double[] res = new double[nums.length / 2];
        for (int i = 0; i < nums.length / 2; i++) {
            res[i] = (nums[i] + nums[nums.length - i - 1]) / (double) 2;
        }

        Arrays.sort(res);
        return res[0];
    }
}
