package yandex.course_2.lesson_3;

import java.util.Scanner;

//https://algocode.ru/page/ekb-7-dynamic-prog/
public class _22_Grasshoper {
    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);

        int n = con.nextInt();
        int k = con.nextInt();

        int i;
        int []dp = new int[35];
        dp[1] = 1;
        dp[2] = 1;

        for (i = 3; i <= k; i++)
            dp[i] = 2 * dp[i - 1];

        for (; i <= n; i++)
            dp[i] = 2 * dp[i - 1] - dp[i - k - 1];

        System.out.println(dp[n]);
    }
}
