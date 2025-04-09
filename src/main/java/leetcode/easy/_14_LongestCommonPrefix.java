package leetcode.easy;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 */
public class _14_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr = new String[]{"flower", "flow", "flight"};
//        String[] arr = new String[]{"dog", "racecar", "car"};
//        System.out.println(longestCommonPrefix(arr));
        System.out.println(findFirstAndLastStr(arr));
    }

    //my bad
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int minLenIndex = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            int curLen = strs[i].length();
            if (minLen > curLen) {
                minLen = curLen;
                minLenIndex = i;
            }
        }

        char[] minStrChars = strs[minLenIndex].toCharArray();
        String prefix = "";
        for (char minStrChar : minStrChars) {
            String possiblePrefix = prefix + minStrChar;
            for (String str : strs) {
                if (!str.startsWith(possiblePrefix)) {
                    return prefix;
                }
            }
            prefix = possiblePrefix;
        }

        return prefix;
    }

    public static String findFirstAndLastStr(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)){
                return res.toString();
            }
            res.append(first.charAt(i));
        }

        return res.toString();
    }
}
