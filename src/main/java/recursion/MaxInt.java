package recursion;

import java.util.Arrays;

public class MaxInt {

    public static void main(String[] args) {
        System.out.println(maxValue_my(new int[]{1, 15, 11, 66, 3, 13, 44}, 0));
        int[] arr = {1, 15, 11, 66, 3, 13, 44};
        System.out.println(maxValueWithIndex(arr, arr.length - 1));
    }

    public static int maxValueWithIndex(int[] arr, int index) {
        if (index > 1) {
            return Math.max(arr[index], maxValueWithIndex(arr, index - 1));
        } else {
            return arr[0];
        }
    }

    public static int maxValue_my(int[] arr, int max) {
        if (arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return max;
        }

        int[] newArr = Arrays.copyOf(arr, arr.length - 1);


        int potential = arr[arr.length - 1];
        int bigger = max > potential ? max : potential;

        return maxValue_my(newArr, bigger);
    }
}
