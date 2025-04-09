package leetcode.easy.stack_LIFO;

import java.util.Stack;

/**
 * Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive).
 * If the character ch does not exist in word, do nothing.
 * <p>
 * For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive).
 * The resulting string will be "dcbaefd".
 * Return the resulting string.
 */
public class _2000_ReversePrefixOfWord {

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
    }

    public static String best(String word, char ch) {
        int i = word.indexOf(ch);

        if (i == -1) {
            return word;
        }

        return new StringBuilder(word.substring(0, i + 1)).reverse().toString() + word.substring(i + 1);
    }

    //my with stack
    public static String reversePrefix(String word, char ch) {
        Stack<Character> stack = new Stack<>();
        int index = -1;
        for (int i = 0; i < word.toCharArray().length; i++) {
            char c = word.charAt(i);
            stack.add(c);

            if (c == ch) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return word;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.append(word, index + 1, word.length());
        return result.toString();
    }
}
