package yandex.course_2.lesson_3;

import java.util.Scanner;

public class _24_Tickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] cust2time = new int[n + 3][3];
        for (int i = 0; i < 3; i++) {
            cust2time[i][0] = Integer.MAX_VALUE;
            cust2time[i][1] = Integer.MAX_VALUE;
            cust2time[i][2] = Integer.MAX_VALUE;
        }
        for (int i = 3; i < n+3; i++) {
            cust2time[i][0] = scanner.nextInt();
            cust2time[i][1] = scanner.nextInt();
            cust2time[i][2] = scanner.nextInt();
        }


        int[] dp = new int[n + 3];
        //dp[i] = min(dp[i-1] + A[i], dp[i-2] + B[i-1], dp[i-3] + c[i-2])
        for (int i = 3; i < n+3; i++) {
            int dpI_1 = dp[i - 1];
            int A = cust2time[i][0];

            int dpI_2 = dp[i - 2];
            int B_1 = cust2time[i - 1][1];

            int dpI_3 = dp[i - 3];
            int C_2 = cust2time[i - 2][2];

            int min = Math.min(dpI_1 + A, Math.min(dpI_2 + B_1, dpI_3 + C_2));
            dp[i] = min;
        }

        System.out.println(dp[dp.length - 1]);
    }
}
