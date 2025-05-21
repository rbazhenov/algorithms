package leetcode.easy;

import java.util.Set;
import java.util.TreeSet;

public class _1385_FindTheDistanceValueBetweenTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;
        System.out.println(findTheDistanceValueBest(arr1, arr2, d));
    }

    public static int findTheDistanceValueBest(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int a : arr1) {
            if (check(a, arr2, d)) {
                count++;
            }
        }
        return count;
    }

    public static boolean check(int a, int[] nums2, int d) {
        for (int b : nums2) {
            if (Math.abs(a - b) <= d) {
                return false;
            }
        }
        return true;
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int number : arr2) {
            tree.add(number);
        }
        for (int val : arr1) {
            int leftValue = val - d;
            int rightValue = val + d;
            Set<Integer> set = tree.subSet(leftValue, rightValue + 1);
            if (set.isEmpty())
                count += 1;
        }
        return count;
    }
}
