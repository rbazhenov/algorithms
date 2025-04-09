package yandex.course_2.lesson_3;

import java.util.Arrays;
import java.util.Scanner;

//https://site.ada.edu.az/~medv/acm/Docs%20e-olimp/Volume%2010/987.htm
public class _25_Carnations {
    static int a[] = new int[101];
    static int dp[] = new int[101];

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        int n = con.nextInt();
        for (int i = 1; i <= n; i++)
            a[i] = con.nextInt();

        Arrays.sort(a, 1, n + 1);

        dp[2] = a[2] - a[1];
        dp[3] = a[3] - a[1];

        for (int i = 4; i <= n; i++)
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + a[i] - a[i - 1];

        System.out.println(dp[n]);

        con.close();
    }
}
