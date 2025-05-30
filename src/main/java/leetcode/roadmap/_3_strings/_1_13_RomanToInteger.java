package leetcode.roadmap._3_strings;

import java.util.HashMap;
import java.util.Map;

public class _1_13_RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
//        String s = "III";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));

            if (i + 1 == s.length() || cur >= map.get(s.charAt(i + 1))) {
                ans += cur;
            } else {
                ans += map.get(s.charAt(i + 1)) - cur;
                i++;
            }
        }

        return ans;
    }
}
