package leetcode.roadmap._6_hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _6_49_GroupAnagrams {
    public static void main(String[] args) {
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
//        String[] strs = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        String[] strs = {"a"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();
        for(String s: strs) {
            String key = "";
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            key = new String(charArray);

            dict.computeIfAbsent(key, k -> new ArrayList<>());
            dict.get(key).add(s);
        }

        return new ArrayList<>(dict.values());
    }
}
