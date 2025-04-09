package yandex.course_1.lesson_6;

import java.util.Arrays;
import java.util.Scanner;

public class a_BinarySearch {
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

        Arrays.sort(nArr);
        for (int i : kArr) {
            System.out.println(binSearch(i, nArr) ? "YES" : "NO");
        }

    }

    private static boolean binSearch(int k, int[] nArr) {
        int l = 0;
        int r = nArr.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nArr[m] < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nArr[l] == k;
    }
}
