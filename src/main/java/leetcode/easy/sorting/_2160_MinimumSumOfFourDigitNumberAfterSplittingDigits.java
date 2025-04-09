package leetcode.easy.sorting;

import java.util.Arrays;

/**
 * You are given a positive integer num consisting of exactly four digits. Split num into two new integers new1 and new2 by using the digits found in num.
 * Leading zeros are allowed in new1 and new2, and all the digits found in num must be used.
 * <p>
 * For example, given num = 2932, you have the following digits: two 2's, one 9 and one 3.
 * Some of the possible pairs [new1, new2] are [22, 93], [23, 92], [223, 9] and [2, 329].
 * Return the minimum possible sum of new1 and new2.
 */
public class _2160_MinimumSumOfFourDigitNumberAfterSplittingDigits {

    public static void main(String[] args) {
        int num = 2932;
        System.out.println(minimumSum2(num));
    }

    public static int minimumSum2(int num) {
        int[] arr = new int[4];

        int i = 0;
        while (num > 0){
            arr[i++] = num % 10;
            num = num/10;
        }
        Arrays.sort(arr);

        return arr[0] * 10 + arr[2] + arr[1] * 10 + arr[3];
    }


    //my bad
    public static int minimumSum(int num) {
        String s = String.valueOf(num);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        Arrays.sort(digits);
        int a = Integer.parseInt(digits[0] + "" + digits[2]);
        int b = Integer.parseInt(digits[1] + "" + digits[3]);
        return a + b;
    }
}
