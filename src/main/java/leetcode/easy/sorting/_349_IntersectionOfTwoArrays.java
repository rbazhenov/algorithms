package leetcode.easy.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. <p>
 * Each element in the result must be unique and you may return the result in any order.
 */
public class _349_IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> unique = new HashSet<>();
        int[] res = new int[Math.max(nums1.length, nums2.length)];

        Arrays.sort(nums2);
        int i = 0;
        for (int num1 : nums1) {
            if (!unique.contains(num1)) {
                unique.add(num1);
                if (Arrays.binarySearch(nums2, num1) >= 0) {
                    res[i++] = num1;
                }
            }
        }

        return Arrays.copyOfRange(res, 0, i);
    }
}
