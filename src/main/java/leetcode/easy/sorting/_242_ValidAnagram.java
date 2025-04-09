package leetcode.easy.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class _242_ValidAnagram {

    public static void main(String[] args) {
        String t = "anagram";
        String s = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            dic.put(key, dic.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            if (!dic.containsKey(key)){
                return false;
            }
            if (dic.get(key) > 1) {
                dic.put(key, dic.get(key) - 1);
            } else {
                dic.remove(key);
            }
        }

        return dic.isEmpty();
    }

    public static boolean best(String s,String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
}
