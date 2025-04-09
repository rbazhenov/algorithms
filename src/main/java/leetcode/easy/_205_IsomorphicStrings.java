package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 */
public class _205_IsomorphicStrings {

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> dic = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if ((dic.containsKey(key) && dic.get(key) != t.charAt(i))
                    || (!dic.containsKey(key) && dic.containsValue(t.charAt(i)))) {
                return false;
            }
            dic.put(key, t.charAt(i));
        }

        return true;
    }
}
