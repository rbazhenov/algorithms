package leetcode.roadmap._2_twopointer;

import java.util.Arrays;

public class _8_283_MoveZeroes {
    public static void main(String[] args) {
//        int[] nums = {0,1};
        int[] nums = {0,1,0,3,12};
//        int[] nums = {2,1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}
