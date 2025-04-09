package yandex.course_2.lesson_3;

import java.util.Scanner;

//https://algocode.ru/page/ekb-7-dynamic-prog/
public class _21_ThreeOnesInRow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println(1);
        } else if (n == 1) {
            System.out.println(2);
        } else if (n == 2) {
            System.out.println(4);
        } else {
            long[] dp = new long[n + 1];
            dp[0] = 1;
            dp[1] = 2;//0,1
            dp[2] = 4;//01,11,00,10
            dp[3] = 7;//000,001,010,100,110,101,011
            //dp[4] = 13;//0000,0001,0010,0100,0110,0101,0011,1000,1001,1010,1100,1101,1011,

            for (int i = 4; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            System.out.println(dp[n]);
        }
    }
}
