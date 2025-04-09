package leetcode.easy.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
 * <p>
 * Note that the strings are case-insensitive, both lowercased and uppercased of the same letter are treated as if they are at the same row.
 */
public class _500_KeyboardRow {

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }

    public static String[] findWords(String[] words) {
        String[] res = new String[words.length];
        int len = 0;
        for (String word : words) {
            int row = getRow(word.charAt(0));
            if (isOneRow(word, row)) {
                res[len++] = word;
            }
        }

        return Arrays.copyOfRange(res, 0, len);
    }

    public static boolean isOneRow(String word, int row) {
        for (int i = 1; i < word.length(); i++) {
            if (getRow(word.charAt(i)) != row) {
                return false;
            }
        }

        return true;
    }

    public static int getRow(char c) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "qwertyuiop");
        map.put(2, "asdfghjkl");
        map.put(3, "zxcvbnm");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().contains(Character.toString(Character.toLowerCase(c)))) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
