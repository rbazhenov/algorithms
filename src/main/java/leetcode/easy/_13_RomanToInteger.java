package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
public class _13_RomanToInteger {

    public static void main(String[] args) {
//        String s = "III";
//        String s = "LVIII";
        String s = "MCMXCIV";
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

        int res = 0;
        char[] array = s.toCharArray();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int next = i + 1;

            if (next == n || map.get(array[i]) >= map.get(array[next])) {
                //если следом пусто, то записываем
                //если следом идёт такой же элемент, то записываем
                res = res + map.get(array[i]);
            } else {
                //если следом идёт другой элемент, то вычитаем из следующего
                int toSum = map.get(array[i + 1]) - map.get(array[i]);
                res = res + toSum;
                i++;
            }
        }

        return res;
    }
}
