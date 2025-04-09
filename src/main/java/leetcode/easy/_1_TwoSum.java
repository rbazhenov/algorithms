package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class _1_TwoSum {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
//        int[] arr = new int[]{3, 2,3};
        int target = 17;
//        int target = 6;
//        System.out.println(Arrays.toString(twoSum(arr, target)));
        System.out.println(Arrays.toString(mapWithOnePass(arr, target)));
    }

    //my bad
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] emptyArr = new int[0];
        if (length == 0) {
            return emptyArr;
        }
        if (length == 1 && nums[0] == target) {
            return new int[]{0};
        }
        if (length == 2 && nums[0] + nums[1] == target) {
            return new int[]{0, 1};
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return emptyArr;
    }

    public static int[] mapWithTwoPass(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int part = target - nums[i];
            if (map.containsKey(part) && map.get(part) != i) {
                return new int[] {i, map.get(part)};
            }
        }

        return new int[]{};
    }

    public static int[] mapWithOnePass(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int part = target - nums[i];
            if (map.containsKey(part) && map.get(part) != i) {
                return new int[] {i, map.get(part)};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
