package leetcode.seanprashad_leetcode_patterns.easy;

import java.util.ArrayList;
import java.util.List;

public class _448_FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        int[] temp = new int[len + 1];
        for (Integer i : nums) {
            temp[i] = 1;
        }

        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
}
