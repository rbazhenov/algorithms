package leetcode.easy.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class _88_MergeSortedArray {

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = new int[]{2, 5, 6};
        int[] nums1 = new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int m = 6;
        int[] nums2 = new int[]{1, 2, 2};
        int n = 3;

//        merge(nums1, m, nums2, n);
//        mergeWithLibrary(nums1, m, nums2, n);
        mergeWithTwoPointer(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    //my bad
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Split = Arrays.copyOfRange(nums1, 0, m);
        int[] sorted = IntStream.concat(Arrays.stream(nums1Split), Arrays.stream(nums2))
                .sorted()
                .toArray();

        System.arraycopy(sorted, 0, nums1, 0, sorted.length);
    }

    public static void mergeWithLibrary(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void mergeWithTwoPointer(int[] nums1, int m, int[] nums2, int n) {
        int mPointer = m - 1;
        int nPointer = n - 1;
        int rightPointer = m + n - 1;

        while (nPointer >= 0) {
            if (mPointer >= 0 && nums1[mPointer] > nums2[nPointer]) {
                nums1[rightPointer] = nums1[mPointer];
                mPointer--;
            } else {
                nums1[rightPointer] = nums2[nPointer];
                nPointer--;
            }
            rightPointer--;
        }
    }

}
