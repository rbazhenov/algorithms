package leetcode.easy.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * You are given an array of strings names, and an array heights that consists of distinct positive integers.
 * Both arrays are of length n.
 * <p>
 * For each index i, names[i] and heights[i] denote the name and height of the ith person.
 * <p>
 * Return names sorted in descending order by the people's heights.
 */
public class _2418_SortThePeople {

    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};

        System.out.println(Arrays.toString(sortPeople2(names, heights)));
    }


    public static String[] sortPeople2(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        String[] res = new String[names.length];
        for (int i = heights.length - 1, k = 0; i >= 0; i--, k++) {
            res[k] = map.get(heights[i]);
        }

        return res;
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, List<String>> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < heights.length; i++) {
            if (map.containsKey(heights[i])) {
                map.get(heights[i]).add(names[i]);
            } else {
                List<String> ns = new ArrayList<>();
                ns.add(names[i]);
                map.put(heights[i], ns);
            }
        }

        System.out.println(map);

        String[] res = new String[names.length];
        int i = 0;
        for (List<String> value : map.values()) {
            for (String s : value) {
                res[i++] = s;
            }
        }

        return res;
    }
}
