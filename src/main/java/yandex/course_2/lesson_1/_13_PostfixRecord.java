package yandex.course_2.lesson_1;

import java.util.Scanner;
import java.util.Stack;

public class _13_PostfixRecord {
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTI = "*";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");

        if (split.length == 0) {
            System.out.println(0);
            return;
        }

        Stack<Integer> stack = new Stack<>();
        for (String numOrOperator : split) {
            if (isNumeric(numOrOperator)) {
                int num = Integer.parseInt(numOrOperator);
                stack.add(num);
            } else {
                String operation = numOrOperator;
                Integer b = stack.pop();
                Integer a = stack.pop();
                int calc = calc(operation, a, b);
                stack.add(calc);
            }
        }

        System.out.println(stack.pop());
    }

    private static boolean isNumeric(String num) {
        try {
            Integer.valueOf(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int calc(String operation, int a, int b) {
        if (PLUS.equals(operation)) {
            return a + b;
        } else if (MINUS.equals(operation)) {
            return a - b;
        } else if (MULTI.equals(operation)) {
            return a * b;
        }

        throw new IllegalArgumentException();
    }
}
