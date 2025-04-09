package leetcode.easy.stack_LIFO;

import java.util.Stack;

/**
 * You are given a string s.
 * <p>
 * Your task is to remove all digits by doing this operation repeatedly:
 * <p>
 * Delete the first digit and the closest non-digit character to its left.<p>
 * Return the resulting string after removing all digits.
 */
public class _3174_ClearDigits {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(clearDigits(s));
    }

    public static String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)){
                stack.add(c);
            } else {
                stack.pop();
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.insert(0, stack.pop());
        }

        return res.toString();
    }
}
