package yandex.course_1.lesson_6;

import java.util.Scanner;

public class b_NearBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = scanner.nextInt();
        }

        int[] kArr = new int[k];
        for (int i = 0; i < k; i++) {
            kArr[i] = scanner.nextInt();
        }

        for (int i : kArr) {
            int index = binsearch(nArr, i);
            System.out.println(nArr[index]);
        }
    }

    private static int binsearch(int[] a, int x) {
        Integer l = rbinsearch(a, x);
        Integer r = lbinsearch(a, x);

        if (l == null) {
            return r;
        } else if (r == null) {
            return l;
        } else {
            return (Math.abs(a[l] - x) > Math.abs(a[r] - x)) ? r : l;
        }
    }

    private static Integer lbinsearch(int[] a, int x) {
        int l = -1;
        int r = a.length;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (a[m] >= x) {
                r = m;
            } else {
                l = m;
            }
        }
        return (r < a.length) ? r : null;
    }

    private static Integer rbinsearch(int[] a, int x) {
        int l = -1;
        int r = a.length;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (a[m] <= x) {
                l = m;
            } else {
                r = m;
            }
        }
        return (l > -1) ? l : null;
    }
}
