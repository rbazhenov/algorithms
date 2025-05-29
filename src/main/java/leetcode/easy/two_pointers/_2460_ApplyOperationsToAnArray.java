package leetcode.easy.two_pointers;

import java.util.Arrays;

public class _2460_ApplyOperationsToAnArray {
    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(Arrays.toString(applyOperations(nums)));
    }

    //1 1 2 2 3 4
    //2 0 4 0 3 4
    //

    //1 1
    public static int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            int n1 = nums[i];
            int n2 = nums[j];
            if (n1 == n2) {
                nums[i] = n1 * 2;
                nums[j] = 0;
            }
        }

        for(int i = 0; i < nums.length - 1; i++){
            int j = i + 1;
            int cur = nums[i];
            if (cur == 0) {
                while (j < nums.length - 1 && nums[j] == 0) {
                    j++;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }

        return nums;
    }
}
