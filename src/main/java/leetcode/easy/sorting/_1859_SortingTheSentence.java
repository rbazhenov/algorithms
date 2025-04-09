package leetcode.easy.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * Each word consists of lowercase and uppercase English letters.
 * <p>
 * A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.
 * <p>
 * For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
 * Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.
 */
public class _1859_SortingTheSentence {

    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(best(s));
    }

    public static String best(String s) {
        String[] str = s.split(" ");
        String[] res = new String[str.length];
        for (String word : str) {
            int i = word.length() - 1;
            res[word.charAt(i) - '1'] = word.substring(0, i);
        }
        return String.join(" ", res);
    }

    public static String sortSentence(String s) {
        String[] arr = s.split(" ");
        Arrays.sort(arr, Comparator.comparingInt(o -> o.charAt(o.length() - 1)));

        String[] res = new String[arr.length];
        int i = 0;
        for (String word : arr) {
            res[i++] = word.substring(0, word.length() - 1);
        }

        return String.join(" ", res);
    }
}
