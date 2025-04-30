package yandex.reviewprepair;

import java.util.HashSet;
import java.util.Set;

public class _2_MyCaseTwoPinter {

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 6, 9, 11, 15};
        int x = 15;

        System.out.println(subArraySum(nums, x));
    }

    private static boolean subArraySum(int[] nums, int x) {
        int left = 0;
        int right = 0;
        int sum = 0;

        while (left < nums.length) {
            while (sum < x && right < nums.length) {
                sum += nums[right++];
            }

            if (sum == x) {
                return true;
            }

            sum -= nums[left];
            left++;
        }

        return false;
    }

    //[-5,-3, [-2, 0, 1, 4], 6, 9]
    //target 3
    //current sum = {-5, -8, -10, -10, -9, -5, 1, 10}
    //reqNum = {-8,}
    private static boolean subArraySumWithNegative(int[] nums, int target) {
        Set<Integer> prefixSum = new HashSet<>();
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            int requiredNum = currentSum - target;
            if (prefixSum.contains(requiredNum)) {
                return true;
            }

            prefixSum.add(currentSum);
        }

        return false;
    }

}
