package recursion;

import java.util.Arrays;

public class Sum {

    public static void main(String[] args) {
        System.out.println(sum(new int[]{4, 1, 6, 7}));
    }

    public static int sum(int[] arr) {
        System.out.println(Arrays.toString(arr));
        if (arr.length == 0) {
            return 0;
        }

        int[] newArr = Arrays.copyOf(arr, arr.length - 1);
        return arr[arr.length-1] + sum(newArr);
    }
}
