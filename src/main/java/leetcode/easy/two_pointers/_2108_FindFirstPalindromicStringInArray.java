package leetcode.easy.two_pointers;

/**
 * Given an array of strings words, return the first palindromic string in the array.
 * If there is no such string, return an empty string "".
 * <p>
 * A string is palindromic if it reads the same forward and backward.
 */
public class _2108_FindFirstPalindromicStringInArray {

    public static void main(String[] args) {
        String[] words = {"pp", "car", "ada", "racecar", "cool"};
        System.out.println(firstPalindrome(words));
    }

    public static String firstPalindrome(String[] words) {
        String res = "";
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }

        return res;
    }

    public static boolean isPalindrome(String word) {
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
