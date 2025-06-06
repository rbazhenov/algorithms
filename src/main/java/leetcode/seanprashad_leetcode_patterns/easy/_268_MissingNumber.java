package leetcode.seanprashad_leetcode_patterns.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _268_MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumberBest(nums));
    }

    public static int missingNumberBest(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len + 1];

        for (int num : nums) {
            temp[num] = 1;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0){
                return i;
            }
        }

        return -1;
    }

    public static int missingNumberFaster(int[] nums) {
        int sum = IntStream.range(0, nums.length + 1)
                .sum();

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }

    public static int missingNumberMySlow(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
