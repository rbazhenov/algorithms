package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        String digits = "234";
        List<String> result = letterCombinations(digits);
        System.out.println(result);
        System.out.println(result.size());
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int len = digits.length();
        if (len == 0) {
            return result;
        }

        Map<Character, String> dict = new HashMap<>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");

        backtrack(new StringBuilder(), digits, dict, result);
        return result;
    }

    private static void backtrack(StringBuilder combination, String nextDigits, Map<Character, String> dict, List<String> result) {
        if (nextDigits.isEmpty()) {
            result.add(combination.toString());
        } else {
            String letters = dict.get(nextDigits.charAt(0));
            for (char letter : letters.toCharArray()) {
                combination.append(letter);
                backtrack(combination, nextDigits.substring(1), dict, result);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }
}
