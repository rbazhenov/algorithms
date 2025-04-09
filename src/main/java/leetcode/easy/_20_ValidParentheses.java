package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class _20_ValidParentheses {

    public static void main(String[] args) {
//        String s = "()[]{}";
//        String s = "([)]";
        String s = "((";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (map.get(pop) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
