package yandex.course_2.lesson_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://education.yandex.ru/handbook/algorithms/article/zadacha-prostoj-kalkulyator
public class _23_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            dp[i] = 1 + dp[i - 1];
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
            }
        }

        List<Integer> operations = new ArrayList<>();
        while (n > 1) {
            operations.add(n);
            if (dp[n] == 1 + dp[n - 1]) {
                n = n - 1;
            } else if (n % 2 == 0 && dp[n] == 1 + dp[n / 2]) {
                n = n / 2;
            } else if (n % 3 == 0 && dp[n] == 1 + dp[n / 3]) {
                n = n / 3;
            }
        }

        //count of operations
        System.out.println(operations.size());

        StringBuilder builder = new StringBuilder("1 ");
        for (int i = operations.size() - 1; i >= 0; i--) {
            builder.append(operations.get(i));
            builder.append(" ");
        }

        System.out.println(builder);
    }
}
