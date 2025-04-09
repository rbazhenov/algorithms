package yandex.course_1.lesson_7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b_PointsAndSegments {
    public static void main(String[] args) {
        //чтение
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        int[] xs = new int[m];
        for (int i = 0; i < m; i++) {
            xs[i] = scanner.nextInt();
        }

        //основная функция
        Map<Integer, Integer> intersections = intersections(a, b, xs);

        //представление ответа
        for (int i = 0; i < xs.length; i++) {
            Integer cnt = intersections.get(xs[i]);
            System.out.print(cnt + " ");
        }
    }

    private static Map<Integer, Integer> intersections(int[] a, int[] b, int[] xs) {
        //числовая прямая. Отрезки, заданные точками начала и конца ab
        //массив m с точками на числовой прямой.
        //Точка x считается принадлежащей отрезку с концами a и b, если выполняется двойное неравенство min(a, b)≤ x ≤ max(a, b)
        //для каждой точки из массива m определить скольким отрезкам она принадлежит.

        int SEG_START = -1;
        int SEG_END = 1;
        int X = 0;

        int[][] events = new int[a.length * 2 + xs.length][2];
        for (int i = 0, j = 0; i < a.length; i++, j += 2) {
            events[j][0] = a[i];
            events[j][1] = SEG_START;
            events[j + 1][0] = b[i];
            events[j + 1][1] = SEG_END;
        }
        for (int i = 0, j = a.length * 2; i < xs.length; i++, j++) {
            events[j][0] = xs[i];
            events[j][1] = X;
        }

        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));

        int cnt = 0;
        Map<Integer, Integer> ans = new HashMap<>(xs.length);
        for (int[] event : events) {
            int type = event[1];
            if (type == SEG_START) {
                cnt++;
            }

            if (type == X) {
                ans.put(event[0], cnt);
            }

            if (type == SEG_END) {
                cnt--;
            }

        }

        return ans;
    }
}
