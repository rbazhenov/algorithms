package leetcode.easy;

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class _9_PalindromeNumber {

    public static void main(String[] args) {
//        System.out.println(isPalindrome(123454321));
        System.out.println(withoutStings(123454321));
    }

    //my bad with String
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);
        int l = s.length();

        char[] left = s.substring(0, l / 2).toCharArray();
        char[] right = l % 2 == 0 ? s.substring(l / 2, l).toCharArray() : s.substring(l / 2 + 1, l).toCharArray();

        for (int i = 0; i < l / 2; i++) {
            if (left[i] != right[right.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean withoutStings(int x) {
        if (x < 0) {
            return false;
        }

        int reversed = 0;
        int xcopy = x;

        while (x>0) {
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }

        return reversed == xcopy;
    }
}
