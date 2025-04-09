package leetcode.roadmap._3_strings;

public class _3_125_ValidPalindrome {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            boolean skip = false;
            char lCh = s.charAt(l);
            char rCh = s.charAt(r);
            if (!Character.isLetterOrDigit(lCh)) {
                l++;
                skip = true;
            }
            if (!Character.isLetterOrDigit(rCh)) {
                r--;
                skip = true;
            }

            if (skip) {
                continue;
            }

            if (Character.toLowerCase(lCh) != Character.toLowerCase(rCh)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
