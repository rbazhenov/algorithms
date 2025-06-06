package sorokin;

import java.util.Stack;

/**
 * Дана строка-выражение вида: "1+38+41*2*3+11" При этом:
 * скобок нет, унарных минусов нет, выитания и деления нет.
 * Есть только сложение и умножение.
 * Ограничения: O(1) по памяти, O(N) по времени
 */
public class _4_CalcString {

    public static void main(String[] args) {
        String expression = "1+38+41*2*3+11";
        System.out.println(calculate(expression));
    }

    private static int calculate(String expression) {
        int result = 0;
        int currentBlockValue = 1;
        int currentVal = 0;

        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '*') {
                if (ch == '+') {
                    currentBlockValue *= currentVal;
                    result += currentBlockValue;
                    currentBlockValue = 1;
                } else {
                    currentBlockValue *= currentVal;
                }
                currentVal = 0;
            } else {
                int digit = ch - '0';
                currentVal = currentVal * 10 + digit;
            }
        }

        currentBlockValue *= currentVal;
        result += currentBlockValue;
        return result;
    }

    //stack version
    private static int calculateWithStack(String expression) {
        Stack<Integer> stack = new Stack<>();
        boolean needMultiply = false;
        int result = 0;
        int currentNumber = 0;
        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '*') {
                //предыдущее и текущее надо сложить. записать -1, если след. операция умнножения
                if (!stack.isEmpty() && needMultiply) {
                    Integer pop = stack.pop();
                    stack.push(pop * currentNumber);
                    if (ch != '*') {
                        needMultiply = false;
                    }

                } else if (ch == '+') {
                    stack.push(currentNumber);
                } else {
                    stack.push(currentNumber);
                    needMultiply = true;
                }

                currentNumber = 0;
            } else {
                int digit = ch - '0';
                currentNumber = currentNumber * 10 + digit;
            }
        }

        if (!stack.isEmpty() && stack.peek() == -1) {
            Integer pop = stack.pop();
            stack.push(pop * currentNumber);
        } else {
            stack.push(currentNumber);
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
