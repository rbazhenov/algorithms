package yandex.reviewprepair;

import java.util.Arrays;

/**
 * Найдите длину максимальной возрастающей подпоследовательности в этом массиве.
 */
public class _5_Dp {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 4, 1, 3, 5, 4, 7};
        System.out.println(countLongestSequence(arr));
    }

    // 1 2 9 3 4
    // 1 2 3 3 4
    private static int countLongestSequence(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int maxDp = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    maxDp = Math.max(maxDp, dp[j]);
                }
            }

            dp[i] = maxDp + 1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
