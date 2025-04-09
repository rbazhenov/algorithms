package lukin;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Дано n дней. Каждый день это темпиратура. Нужно для каждого дня посчитать кол-во суток до наступления более теплой темпиратуры.
 */
public class NextBigInt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tempArr = new int[n];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = scanner.nextInt();
        }

        long myBefore = System.currentTimeMillis();
        System.out.println(Arrays.toString(my(tempArr)));
        long myAfter = System.currentTimeMillis();
        System.out.println("My speed = " + (myAfter - myBefore));

        long before = System.currentTimeMillis();
        System.out.println(Arrays.toString(temperatureWithStack(tempArr)));
        long after = System.currentTimeMillis();
        System.out.println("Speed = " + (after - before));

    }

    /**
     * Сложность по памяти O(n). Время работы O(n).
     */
    private static int[] temperatureWithStack(int[] arr) {
        Stack<SupportClass> stack = new Stack<>();
        int[] answer = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().getValue() <= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer[i] = stack.peek().getIndex() - i;
            }

            stack.push(new SupportClass(arr[i], i));
        }


        return answer;
    }

    /**
     * Время работы O(n^2) от n в квадрате.
     * </p>
     * Память O(n) | O(1).
     * </p>
     * Для каждого дня важны ответы только справа.
     * </p>
     * Получаем идею: запоминать наш ответ справа-налево.
     */
    private static int[] my(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Вспомогательный класс для работы с двумя значениями.
     */
    private static class SupportClass {
        private int value;
        private int index;

        public SupportClass(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
