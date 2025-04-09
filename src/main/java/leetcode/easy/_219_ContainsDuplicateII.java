package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class _219_ContainsDuplicateII {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {1, 2, 3, 1, 2, 3};
//        int k = 3;
        int k = 2;
        System.out.println(best(nums, k));
    }

    public static boolean best(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (seen.containsKey(val) && i - seen.get(val) <= k) {
                return true;
            }
            seen.put(val, i);
        }

        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> dic = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            List<Integer> indexes = new ArrayList<>();
            if (!dic.containsKey(key)) {
                indexes.add(i);
            } else {
                indexes = dic.get(key);
                indexes.add(i);
            }
            dic.put(key, indexes);
        }

        for (Map.Entry<Integer, List<Integer>> entry : dic.entrySet()) {
            List<Integer> indexes = entry.getValue();
            if (indexes.size() > 1) {
                for (int i = 0; i < indexes.size() - 1; i++) {
                    for (int j = i + 1; j < indexes.size(); j++) {
                        if (Math.abs(indexes.get(i) - indexes.get(j)) <= k) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static boolean containsNearbyDuplicateNsqrt2(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
