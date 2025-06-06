package leetcode.seanprashad_leetcode_patterns.easy;

import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> uniq = new HashSet<>();
        for (int num : nums) {
            if (uniq.contains(num)) {
                return true;
            }
            uniq.add(num);
        }

        return false;
    }
}
