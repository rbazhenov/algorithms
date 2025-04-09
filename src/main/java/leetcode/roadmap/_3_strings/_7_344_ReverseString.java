package leetcode.roadmap._3_strings;

import java.util.Arrays;

public class _7_344_ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;

        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
