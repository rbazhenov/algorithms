package leetcode.seanprashad_leetcode_patterns.easy;

import java.util.Arrays;

public class _977_SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int j = n - 1;
        int i = 0;
        int lastResIndex = n - 1;
        while(i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[lastResIndex--] = nums[i] * nums[i];
                i++;
            } else {
                res[lastResIndex--] = nums[j] * nums[j];
                j--;
            }
        }

        return res;
    }
}
