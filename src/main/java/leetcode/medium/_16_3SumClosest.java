package leetcode.medium;

import java.util.Arrays;

public class _16_3SumClosest {
    public static void main(String[] args) {
//        int[] nums = {-1, 2, 1, -4};
//        int[] nums = {0,0,0};
//        int[] nums = {0,1,2};
        int[] nums = {-4, 2, 2, 3, 3, 3};
        int target = 0;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE / 2;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    return sum;
                }

            }
        }

        return result;
    }
}
