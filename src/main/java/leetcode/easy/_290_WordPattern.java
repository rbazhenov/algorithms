package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:
 * <p>
 * Each letter in pattern maps to exactly one unique word in s. <p>
 * Each unique word in s maps to exactly one letter in pattern. <p>
 * No two letters map to the same word, and no two words map to the same letter.
 */
public class _290_WordPattern {

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        if (pattern.length() != sArr.length) {
            return false;
        }

        Map<Character, String> dic = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            if ((dic.containsKey(key) && !dic.get(key).equals(sArr[i]))
                    || (!dic.containsKey(key) && dic.containsValue(sArr[i]))) {
                return false;
            }

            dic.put(key, sArr[i]);
        }

        return true;
    }
}
