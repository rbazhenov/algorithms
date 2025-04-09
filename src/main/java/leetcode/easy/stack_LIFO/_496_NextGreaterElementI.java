package leetcode.easy.stack_LIFO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * <p>
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * <p>
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
 * If there is no next greater element, then the answer for this query is -1.
 * <p>
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 */
public class _496_NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,2,4};
//        int[] nums1 = {3,1,5,7,9,2,6};
        int[] nums2 = {6,5,4,3,2,1,7};
//        int[] nums2 = {1,2,3,5,6,7,9,11};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);
            }
            stack.add(num);
        }

        int[] res = new int[nums1.length];
        int i = 0;
        for (int num : nums1) {
            res[i++] = map.getOrDefault(num, -1);
        }

        return res;
    }
}
