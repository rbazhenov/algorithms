package yandex.course_1.lesson_6;

import java.util.Scanner;

public class c_Diplomas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println(binSearch(w, h, n));
    }

    //2 3 10
    private static int binSearch(int w, int h, int n) {
        int l = 0;
        int r = Math.max(w, h) * n;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if ((m / h) * (m / w) >= n) {
                r = m;
            } else {
                l = m;
            }
        }

        return r;
    }
}
