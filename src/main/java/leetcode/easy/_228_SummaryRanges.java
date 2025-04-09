package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 * <p>
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b <p>
 * "a" if a == b
 */
public class _228_SummaryRanges {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 4, 5, 7};
//        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        int[] nums = {1};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> strs = new ArrayList<>();
        if (nums.length == 0) {
            return strs;
        }
        if (nums.length == 1) {
            strs.add(String.valueOf(nums[0]));
            return strs;
        }

        String temp = String.valueOf(nums[0]);
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                if (temp.contains("->")) {
                    strs.add(k, temp + nums[i - 1]);
                } else {
                    strs.add(k, temp);
                }

                temp = String.valueOf(nums[i]);
                k++;
            } else {
                temp = temp.charAt(temp.length() - 1) == '>' ? temp : temp + "->";
                if (i == nums.length - 1) {
                    temp = temp + nums[i];
                }
            }

            if (i == nums.length - 1) {
                strs.add(k, temp);
            }
        }

        return strs;
    }
}
