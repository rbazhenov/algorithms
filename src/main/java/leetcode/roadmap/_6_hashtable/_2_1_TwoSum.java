package leetcode.roadmap._6_hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _2_1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        //key - diff, value = index
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int diff = target - curr;
            if (dict.containsKey(diff)) {
                ans[0] = i;
                ans[1] = dict.get(diff);
            } else {
                dict.put(curr, i);
            }
        }

        return ans;
    }
}
