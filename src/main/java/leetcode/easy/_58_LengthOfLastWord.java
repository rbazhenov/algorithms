package leetcode.easy;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal substring consisting of non-space characters only.
 */
public class _58_LengthOfLastWord {

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(s.length() - 1 - i);
            if (c != ' ') {
                res++;
                continue;
            }
            if (res != 0) {
                return res;
            }
        }
        return res;
    }
}
