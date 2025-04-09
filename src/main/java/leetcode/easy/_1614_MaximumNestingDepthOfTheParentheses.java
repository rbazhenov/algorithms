package leetcode.easy;

import java.util.Stack;

/**
 * Given a valid parentheses string s, return the nesting depth of s.
 * The nesting depth is the maximum number of nested parentheses.
 */
public class _1614_MaximumNestingDepthOfTheParentheses {

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        char open = '(';
        char close = ')';

        int op = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == open) {
                op++;
            }
            if (c == close) {
                res = Math.max(res, op);
                op--;
            }
        }

        return res;
    }
}
