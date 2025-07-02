package leetcode.easy.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
public class _169_MajorityElement {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElementBest(arr));
//        System.out.println(sortFirst(arr));
    }

    public static int majorityElementBest(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    //my bad
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

//        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return 0;
    }

    public static int sortFirst(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
