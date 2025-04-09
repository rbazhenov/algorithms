package leetcode.easy.two_pointers;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */
public class _28_FindTheIndexOfTheFirstOccurrenceInString {

    public static void main(String[] args) {
//        String haystack = "sadbutsad";
        String haystack = "a";
//        String needle = "sad";
        String needle = "a";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int needleLen = needle.length();
        for (int i = 0; i < haystack.length() - needleLen + 1; i++) {
            if (haystack.substring(i, needleLen + i).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
