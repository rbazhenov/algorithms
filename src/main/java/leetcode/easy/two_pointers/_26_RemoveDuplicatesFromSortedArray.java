package leetcode.easy.two_pointers;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * <p>
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * <p>
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * <p>
 * int k = removeDuplicates(nums); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 */
public class _26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        System.out.println("nums: " + Arrays.toString(nums));
    }

    //my bad
    public static int removeDuplicates(int[] nums) {
        int l = nums.length;
        if (l == 0) {
            return 0;
        }
        if (l == 1) {
            return 1;
        }

        int pointerA = 0;
        int pointerB = 1;
        int res = 1;
        int[] tempArr = new int[l];
        int tempArrIndex = 0;
        while (pointerB < l) {
            if (nums[pointerA] != nums[pointerB]) {
                res++;
                tempArr[tempArrIndex++] = nums[pointerA];
                pointerA = pointerB;
            }

            pointerB++;
        }
        tempArr[tempArrIndex] = nums[l - 1];

        System.arraycopy(tempArr, 0, nums, 0, l);

        return res;
    }

    public static int shorter(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int k = 1; // Initialize the count of unique elements to 1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i]; // Overwrite the next unique element
                k++;
            }
        }

        return k;
    }
}
