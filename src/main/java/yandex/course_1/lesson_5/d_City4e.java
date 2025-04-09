package yandex.course_1.lesson_5;

import java.util.Scanner;

public class d_City4e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextInt();
        }

        System.out.println(calcCouples(d, r));

    }

    //массив отсортирован и без дубликатов
    private static int calcCouples(int[] d, int fog) {
        int[] delta = new int[d.length];
        for (int i = 1; i < d.length; i++) {
            delta[i] = delta[i - 1] + d[i] - d[i - 1];
        }

        int l = 0;
        int r = 0;
        int lastIndex = delta.length - 1;
        int cnt = 0;

        boolean toNextR = true;
        while (true) {
            int distance = delta[r] - delta[l];
            if (distance > fog) {
                cnt++;
                l++;
            } else {
                toNextR = true;
            }

            if (l == r) {
                toNextR = true;
            }

            if (toNextR){
                if (r < lastIndex) {
                    r++;
                    toNextR = false;
                } else {
                    break;
                }
            }

        }

        return cnt;
    }
}
