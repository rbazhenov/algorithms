package leetcode.easy.string;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * <p>
 * Return the merged string.
 */
public class _1768_MergeStringsAlternately {

    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqrs";
        System.out.println(best(word1, word2));
    }

    public static String best(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int minLen = Math.min(word1.length(), word2.length());
        for (int i = 0; i < minLen; i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }

        if (word1.length()> word2.length()){
            result.append(word1.substring(minLen));
        } else {
            result.append(word2.substring(minLen));
        }

        return result.toString();
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int maxLen = Math.max(word1.length(), word2.length());
        for (int i = 0; i < maxLen; i++) {
            if (word1.length() > i){
                result.append(word1.charAt(i));
            }
            if (word2.length() > i){
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }
}
