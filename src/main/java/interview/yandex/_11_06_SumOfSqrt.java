package interview.yandex;

import java.util.ArrayList;
import java.util.List;

/**
 * Дано натуральное число.
 * Вернуть список целых чисел, сумма квадратов которых даст исходное число.
 */
public class _11_06_SumOfSqrt {
    public static List<Integer> findSquares(int n) {
        return backtrack(n, (int) Math.sqrt(n), new ArrayList<>());
    }

    private static List<Integer> backtrack(int remaining, int start, List<Integer> path) {
        if (remaining == 0) {
            return new ArrayList<>(path);
        }

        for (int i = start; i >= 1; i--) {
            int square = i * i;
            if (square <= remaining) {
                path.add(i);
                List<Integer> result = backtrack(remaining - square, i - 1, path);
                if (result != null) return result;
//                path.removeLast(); // backtrack
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int n = 13;
        List<Integer> result = findSquares(n);
        if (result != null) {
            System.out.println("Список: " + result); // Пример: [3, 2]
        } else {
            System.out.println("Решение не найдено");
        }
    }
}
