package leetcode.seanprashad_leetcode_patterns.easy;

import java.util.HashSet;
import java.util.Set;

public class _136_SingleNumber {
    public static void main(String[] args) {
//        int[] nums = {2,2,1};
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumberBest(nums));
    }

    public static int singleNumberBest(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        return xor;
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> uniq = new HashSet<>();
        for (int num : nums) {
            if (uniq.contains(num)){
                uniq.remove(num);
            } else {
                uniq.add(num);
            }
        }

        return uniq.iterator().next();
    }
}
