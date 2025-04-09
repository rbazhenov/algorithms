package yandex.course_1.lesson_5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class a_StyledDress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nColors = new int[n];
        for (int i = 0; i < n; i++) {
            nColors[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] mColors = new int[m];
        for (int i = 0; i < m; i++) {
            mColors[i] = scanner.nextInt();
        }

        int[] ab = calcStyledColors(nColors, mColors);
        System.out.println(ab[0] + " " + ab[1]);
    }

    private static int[] calcStyledColors(int[] a, int[] b) {
        int iLast = a.length - 1;
        int jLast = b.length - 1;
        int i = 0;
        int j = 0;

        Map<Integer, int[]> delta = new HashMap<>();
        delta.put(Math.abs(a[i] - b[j]), new int[]{a[i], b[j]});
        while (i < iLast || j < jLast) {
            if (delta.containsKey(0)) {
                int[] minDelta = delta.get(0);
                return new int[]{minDelta[0], minDelta[1]};
            }

            if (i < iLast && (a[i] < b[j] || j == jLast)) {
                i++;
            } else {
                j++;
            }
            delta.put(Math.abs(a[i] - b[j]), new int[]{a[i], b[j]});
        }

        Integer minDelta = Collections.min(delta.keySet());
        int[] ids = delta.get(minDelta);
        return new int[]{ids[0], ids[1]};
    }
}
