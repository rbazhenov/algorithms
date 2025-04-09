package leetcode.easy;

import java.math.BigInteger;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 */
public class _67_AddBinary {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        return (new BigInteger(a, 2).add(new BigInteger(b, 2))).toString(2);
    }
}
