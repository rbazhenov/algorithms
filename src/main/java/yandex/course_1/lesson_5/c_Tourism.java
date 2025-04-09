package yandex.course_1.lesson_5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class c_Tourism {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        }

        int m = Integer.parseInt(scanner.nextLine());
        int[][] tracks = new int[m][2];
        for (int i = 0; i < m; i++) {
            List<Integer> lr = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            tracks[i][0] = lr.get(0);
            tracks[i][1] = lr.get(1);
        }

        riseSum(y, tracks);
    }

    //n + n + m*n = O(NM). А надо N+M
    private static void riseSum(int[] y, int[][] tracks) {
        int[] l2r = new int[y.length];
        for (int i = 1; i < y.length; i++) {
            l2r[i] = y[i] - y[i - 1];
        }

        int[] r2l = new int[y.length];
        for (int i = 0; i < r2l.length - 1; i++) {
            r2l[i] = l2r[i + 1] * -1;
        }

        for (int i = 0; i < tracks.length; i++) {
            int l = tracks[i][0] - 1;
            int r = tracks[i][1] - 1;

            int sum = 0;
            if (r > l) {
                for (int j = l + 1; j <= r; j++) {
                    if (l2r[j] > 0) {
                        sum += l2r[j];
                    }
                }
            } else if (l > r) {
                for (int j = r; j <= l - 1; j++) {
                    if (r2l[j] > 0) {
                        sum += r2l[j];
                    }
                }
            }

            System.out.println(sum);
        }
    }
}
