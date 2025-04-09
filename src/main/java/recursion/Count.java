package recursion;

import java.util.Arrays;

public class Count {

    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 2, 3, 4, 5, 6}));
    }

    public static int count(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int[] newArr = Arrays.copyOf(arr, arr.length - 1);
        return 1 + count(newArr);
    }
}
