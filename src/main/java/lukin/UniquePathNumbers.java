package lukin;

import java.util.Scanner;

/**
 * Количество Уникальных Путей.
 * <p>
 * Дано: Сетка NxM. Роботу в ячейке 1х1 нужно добраться до ячейки AxB(противоположный угол). </p>
 * Робот может ходить только вправо и вверх.
 */
public class UniquePathNumbers {

    private static long path1Count = 0;
    private static long path2Count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        long p1before = System.currentTimeMillis();
        System.out.println(paths(n, m));
        long p1after = System.currentTimeMillis();
        System.out.println(" Count = " + path1Count + " time for first = " + (p1after - p1before));

        long p2before = System.currentTimeMillis();
        System.out.println(paths2(n, m));
        long p2after = System.currentTimeMillis();
        System.out.println(" Count = " + path2Count + " time for second = " + (p2after - p2before));
    }

    /**
     * Оптимальный. Скорость O(N+M). Запоминаем ячейку, чтобы не идти по ней дважды.
     */
    private static long paths2(int n, int m) {
        return helper(n, m, new long[n + 1][m + 1]);
    }

    private static long helper(int n, int m, long[][] arr) {
        path2Count++;
        if (n == 1 && m == 1) {
            return 1;
        }
        if (n <= 0 || m <= 0) {
            return 0;
        }
        //Если мы уже запоминали ячейку, то берём из памяти.
        if (arr[n][m] != 0) {
            return arr[n][m];
        }

        long pathsN = helper(n - 1, m, arr);
        long pathsM = helper(n, m - 1, arr);
        arr[n][m] = pathsN + pathsM;
        return arr[n][m];
    }

    /**
     * Долгий. Скорость O(2*n+m). О от двух в степени n+m.
     */
    private static long paths(int n, int m) {
        path1Count++;
        if (n == 1 && m == 1) {
            return 1;
        }
        if (n <= 0 || m <= 0) {
            return 0;
        }

        long pathsN = paths(n - 1, m);
        long pathsM = paths(n, m - 1);
        return pathsN + pathsM;
    }

}
