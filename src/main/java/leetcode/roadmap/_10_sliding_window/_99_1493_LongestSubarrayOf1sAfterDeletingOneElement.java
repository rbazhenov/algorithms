package leetcode.roadmap._10_sliding_window;

public class _99_1493_LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int max = 0;
        int j = 0;
        int cntZero = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && cntZero < 2) {
                if (nums[j] == 0) {
                    cntZero++;
                }
                j++; //3, i = 1
            }

            int minus = cntZero == 2 ? 2 : 1;
            max = Math.max(max, j - i - minus);

            if (nums[i] == 0) {
                cntZero--;
            }
        }

        return max;
    }
}
