package leetcode.roadmap._2_twopointer;

import java.util.Arrays;

public class _3_350_IntersectionOfTwoArraysII {
    public static void main(String[] args) {
//        int[] nums1 = {2, 1};
//        int[] nums1 = {1,2,2,1};
        int[] nums1 = {3,1,2};
//        int[] nums2 = {1, 2};
//        int[] nums2 = {2,2};
        int[] nums2 = {1,1};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < l1 && j < l2) {
            if (nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i++];
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }
}
