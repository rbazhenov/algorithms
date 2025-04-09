package leetcode.roadmap._2_twopointer;

import java.util.Arrays;

public class _4_167_TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers = {-10, -8, -2, 1, 2, 5, 6};
        int target = 0;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (true) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
    }
}
