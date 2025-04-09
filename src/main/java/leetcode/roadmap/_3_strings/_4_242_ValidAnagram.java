package leetcode.roadmap._3_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _4_242_ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagramBest(String s, String t){
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (cnt.containsKey(ch)) {
                int newVal = cnt.get(ch) - 1;
                if (newVal == 0) {
                    cnt.remove(ch);
                } else {
                    cnt.put(ch, newVal);
                }
            } else {
                return false;
            }
        }

        return cnt.isEmpty();
    }
}
