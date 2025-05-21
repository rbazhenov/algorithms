package leetcode.roadmap._6_hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _4_290_WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> dict = new HashMap<>();
        s = s.trim();
        String[] split = s.split(" ");

        if (pattern.length() != split.length) {
            return false;
        }

        Set<String> words = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String word = split[i];
            if ((dict.containsKey(key) && !dict.get(key).equals(word))
                    || (!dict.containsKey(key) && words.contains(word))) {
                return false;
            } else {
                dict.put(key, word);
                words.add(word);
            }
        }
        return true;
    }
}
