package leetcode.roadmap._2_twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _9_763_PartitionLabels {

    public static void main(String[] args) {
//        String s = "ababcbacadefegdehijhklij";
//        String s = "eccbbbbdec";
        String s = "qiejxqfnqceocmy";
//        System.out.println(partitionLabels(s));
        System.out.println(partitionLabelsUseCharMassive(s));
    }

    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> ends = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            ends.putIfAbsent(s.charAt(i), i);
        }

        List<Integer> ans = new ArrayList<>();
        int prev = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            max = Math.max(max, ends.get(ch));
            if (max == i) {
                ans.add(max - prev);
                prev = max;
            }
        }

        return ans;
    }

    public static List<Integer> partitionLabelsUseCharMassive(String s) {
        int[] ends = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            ends[index] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int prev = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            max = Math.max(max, ends[ch - 'a']);
            if (max == i) {
                ans.add(max - prev);
                prev = max;
            }
        }

        return ans;
    }
}
