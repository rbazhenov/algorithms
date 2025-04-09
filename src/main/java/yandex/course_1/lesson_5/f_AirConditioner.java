package yandex.course_1.lesson_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class f_AirConditioner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //кол-во классов в школе
        int n = scanner.nextInt();
        //минимальная мощность кондиционера в классах
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        //кол-во моделей кондиционеров
        int m = scanner.nextInt();
        //b - мощность кондиционера и c - стоимость
        int[][] bc = new int[m][2];
        for (int i = 0; i < m; i++) {
            bc[i][0] = scanner.nextInt();
            bc[i][1] = scanner.nextInt();
        }

        //найти минимальную стоимость кондиционеров, чтобы они были во всех классах
        System.out.println(calcCost(a, bc));
    }

    private static long calcCost(int[] a, int[][] bc) {
        Arrays.sort(a);
        Arrays.sort(bc, Comparator.comparingInt(t -> t[1]));

        long s = 0;
        int r = 0;
        for (int minPower : a) {
            while (r < bc.length && minPower > bc[r][0]) {
                r++;
            }
            if (r < bc.length) {
                s += bc[r][1];
            }
        }

        return s;
    }

}
