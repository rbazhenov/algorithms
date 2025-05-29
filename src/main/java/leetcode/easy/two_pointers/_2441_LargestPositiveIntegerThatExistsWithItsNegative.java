package leetcode.easy.two_pointers;

import java.util.Arrays;

public class _2441_LargestPositiveIntegerThatExistsWithItsNegative {

    public static void main(String[] args) {
//        int[] nums = {-1, 2,-3, 3};
//        int[] nums = {-1,10,6,7,-7,1};
        int[] nums = {-10,8,6,7,-2,-3};
        System.out.println(findMaxK(nums));
    }

    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[r] + nums[l];
            if (sum == 0) {
                return nums[r];
            } else if (sum > 0){
                r--;
            } else {
                l++;
            }
        }

        return -1;
    }
}
