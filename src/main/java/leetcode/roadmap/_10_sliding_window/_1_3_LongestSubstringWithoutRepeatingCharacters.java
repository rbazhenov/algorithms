package leetcode.roadmap._10_sliding_window;

import java.util.HashSet;
import java.util.Set;

public class _1_3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> uniq = new HashSet<>();

        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);

            if (uniq.contains(cur)) {
                while (i < j && s.charAt(i) != cur) {
                    uniq.remove(s.charAt(i));
                    i++;
                }
                uniq.remove(s.charAt(i++));
            }

            uniq.add(cur);
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}
