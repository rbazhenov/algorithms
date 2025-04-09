package yandex.course_1.lesson_6;

import java.util.Scanner;

public class f_VerySimpleTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        n--;
        int res = Math.min(x, y);

        if (n > 0) {
            res += binSearch(n, x, y);
        }

        System.out.println(res);
    }

    private static int binSearch(int n, int x, int y) {
        int l = 0;
        int r = n * Math.max(x, y) + 1;//печатаем только на одном и самом долгом
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            int printed = m / x + m / y;
            if (printed >= n) {
                r = m;
            } else {
                l = m;
            }
        }

        return r;
    }
}
