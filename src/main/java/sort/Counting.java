package sort;

import java.util.Arrays;

/**
 * Только если последовательность не отрицательная. <p>
 * Подходит для небольших интервалов, где значения часто встречаются. <p>
 * 1. Определяем минимум и максимум. <p>
 * 2. Создать пустой массив длиной |max-min|
 * 3. Считаем кол-во повторений числа
 */
public class Counting {

    public static void main(String[] args) {
        int[] grades = {1, 5, 3, 2, 3, 5, 1, 2, 5};
        System.out.println(Arrays.toString(sortByCounting(grades)));
    }

    public static int[] sortByCounting(int[] grades) {
        if (grades.length < 2) {
            return grades;
        }
        if (grades.length == 2) {
            int a = grades[0];
            int b = grades[1];
            grades[0] = Math.min(a, b);
            grades[1] = Math.max(a, b);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
            if (grade < min) {
                min = grade;
            }
        }

        int len = max - min + 1;
        int[] sortedWithZeros = new int[len];

        for (int grade : grades) {
            sortedWithZeros[grade - min] += 1;
        }

        int newPos = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < sortedWithZeros[i]; j++) {
                grades[newPos] = min + i;
                newPos++;
            }
        }

        return grades;
    }

    public static int[] sortByCounting_r(int[] grades) {
        if (grades.length < 2) {
            return grades;
        }
        if (grades.length == 2) {
            int a = grades[0];
            int b = grades[1];
            grades[0] = Math.min(a, b);
            grades[1] = Math.max(a, b);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int grade : grades) {
            max = Math.max(max, grade);
            min = Math.min(min, grade);
        }

        int len = max - min + 1;
        //количество повторений числа. индекс = число. значение = кол-во раз встретилось
        int[] sortedWithZeros = new int[len];

        for (int grade : grades) {
            sortedWithZeros[grade - min] += 1;
        }

        int newPos = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < sortedWithZeros[i]; j++) {
                grades[newPos] = min + i;
                newPos++;
            }
        }

        return grades;
    }
}
