package leetcode.easy;

import java.util.Arrays;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 */
public class _66_PlusOne {

    public static void main(String[] args) {
        int[] digits = {0};
//        int[] digits = {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 9};
        System.out.println(Arrays.toString(plusOneArray(digits)));
    }

    public static int[] best(int[] digits) {
        int len = digits.length;
        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newArr = new int[len + 1];
        newArr[0] = 1;
        return newArr;
    }

    //тоже самое, что и best, но много лишнего.
    public static int[] plusOneArray(int[] digits) {
        int len = digits.length;
        for (int i = 0; i < len; i++) {
            int curId = len - 1 - i;
            int prevId = len - 2 - i;

            if (prevId < 0 && digits[curId] == 9) {
                digits[curId] = 10;
                continue;
            }

            if (digits[curId] < 9) {
                digits[curId] = digits[curId] + 1;
                return digits;
            } else if (digits[curId] == 9) {
                digits[curId] = 0;
            } else {
                //digits[curId] == 10
                digits[curId] = 0;
                digits[prevId] = digits[prevId] + 1;

            }
        }

        if (digits[0] == 10) {
            int[] newArr = new int[len + 1];
            newArr[0] = 1;
            return newArr;
        }

        return digits;
    }


    //not work for big arrays
    public static int[] plusOneString(int[] digits) {
        StringBuilder strBuilder = new StringBuilder();
        for (int digit : digits) {
            strBuilder.append(digit);
        }

        String newValue = String.valueOf(Long.parseLong(strBuilder.toString()) + 1);
        int[] newArr = new int[newValue.length()];
        int i = 0;
        for (char c : newValue.toCharArray()) {
            newArr[i] = Integer.parseInt(Character.toString(c));
            i++;
        }

        return newArr;
    }
}
