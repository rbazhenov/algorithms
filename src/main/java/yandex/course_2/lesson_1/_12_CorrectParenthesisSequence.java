package yandex.course_2.lesson_1;

import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class _12_CorrectParenthesisSequence {

    public static Set<Character> openTypes = Set.of('(', '[', '{');

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        boolean correct = isCorrect(line);
        System.out.println(correct ? "yes" : "no");
    }

    private static boolean isCorrect(String line) {
        if (line.isBlank()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        stack.add(line.charAt(0));
        for (int i = 1; i < line.length(); i++) {
            char ch = line.charAt(i);

            //если встретится открывающая, то проверяем последовательность этого типа
            //если встретиться новый тип, то смотрим чтобы предыдущего типа была закрыта
            if (stack.isEmpty()) {
                if (!openTypes.contains(ch)) {
                    return false;
                }
                stack.add(ch);
                continue;
            }
            Character peek = stack.peek();
            if (isSameType(peek, ch) && !oneTypeCheck(stack, ch)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean oneTypeCheck(Stack<Character> stack, char ch) {
        if (openTypes.contains(ch)) {
            stack.add(ch);
        } else {
            if (stack.isEmpty() || !openTypes.contains(stack.peek())) {
                return false;
            }
            stack.pop();
        }

        return true;
    }

    private static boolean isSameType(char type, char ch) {
        if (type == '(' || type == ')') {
            return ch == '(' || ch == ')';
        } else if (type == '[' || type == ']') {
            return ch == '[' || ch == ']';
        } else if (type == '{' || type == '}') {
            return ch == '{' || ch == '}';
        }

        return false;
    }

}
