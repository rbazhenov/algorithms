package yandex.course_1.lesson_5;

import java.util.Scanner;

public class c_Tourism2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        }

        int[] l2r = new int[n + 1];
        int[] r2l = new int[n + 1];

        for (int i = 1; i < n; i++) {
            int h = Math.max(y[i] - y[i - 1], 0);
            l2r[i + 1] = l2r[i] + h;
        }

        for (int i = n - 1; i > 0; i--) {
            int h = Math.max(y[i - 1] - y[i], 0);
            r2l[i] = r2l[i + 1] + h;
        }

        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int f = Integer.parseInt(input[1]);
            int ans;
            if (s > f) {
                ans = r2l[f] - r2l[s];
            } else {
                ans = l2r[f] - l2r[s];
            }
            System.out.println(ans);
        }
    }
}
