package leetcode.easy.two_pointers;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class _392_IsSubsequence {

    public static void main(String[] args) {
        String sub = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(sub, t));
    }

    //my bad
    public static boolean isSubsequence(String sub, String t) {
        if (sub.isEmpty()) {
            return true;
        }

        if (t.isEmpty()) {
            return false;
        }

        int si = 0;
        for (int i = 0; i < t.length() && si < sub.length(); i++) {
            if (sub.charAt(si) == t.charAt(i)) {
                si++;
            }
        }

        return sub.length() == si;
    }

    public static boolean best(String s, String t) {
        int n = s.length(), m = t.length(), i = 0, j = 0;

        while (i < n) {
            char cur = s.charAt(i);
            while (j < m && t.charAt(j) != cur) {
                j++;
            }
            if (j >= m) {
                return false;
            }
            j++;
            i++;
        }

        return true;
    }
}
