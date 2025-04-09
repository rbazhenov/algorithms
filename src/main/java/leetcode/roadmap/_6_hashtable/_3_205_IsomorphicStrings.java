package leetcode.roadmap._6_hashtable;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class _3_205_IsomorphicStrings {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphicBest(s, t));
    }

    public static boolean isIsomorphicBest(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> dict = new HashMap<>();
        Set<Character> unique = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if ((dict.containsKey(key) && dict.get(key) != t.charAt(i))
                    || (!dict.containsKey(key) && unique.contains(t.charAt(i)))) {
                return false;
            } else {
                dict.put(key, t.charAt(i));
                unique.add(t.charAt(i));
            }
        }

        return true;
    }

    //my ban O(nLogN)
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> cntS = new HashMap<>();
        Map<Character, Integer> cntT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cntS.put(ch, cntS.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            cntT.put(ch, cntT.getOrDefault(ch, 0) + 1);
        }

        if (cntS.size() != cntT.size()) {
            return false;
        }

        Collection<Integer> valuesS = cntS.values();
        Collection<Integer> valuesT = cntT.values();

        List<Integer> sortedS = valuesS.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> sortedT = valuesT.stream()
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < sortedT.size(); i++) {
            if (sortedS.get(i).intValue() != sortedT.get(i).intValue()) {
                return false;
            }
        }

        return true;
    }
}
