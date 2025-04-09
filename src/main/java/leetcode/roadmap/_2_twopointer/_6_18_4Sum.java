package leetcode.roadmap._2_twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _6_18_4Sum {
    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int target = 8;
        int[] nums = {2,2,2,2,2};
        int target = 8;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);
        for (int a = 0; a < nums.length-3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < nums.length-2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                int j = b + 1;
                int k = nums.length - 1;
                while (j < k) {
                    long sum = (long) nums[a] + nums[b] + nums[j] + nums[k];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[a], nums[b], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k + -1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (sum > target) {
                        k--;
                    } else if (sum < target) {
                        j++;
                    }
                }
            }
        }

        return ans;
    }
}
