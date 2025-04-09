package yandex.course_1.lesson_5;

import java.util.Scanner;

public class b_NumberSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(countCouples(n, k, nums));
    }

    private static int countCouples(int n, int k, int[] nums) {
        int lastIndex = n - 1;
        int l = 0;
        int r = 0;
        int sum = nums[0];

        boolean toNextL = false;
        boolean toNextR = false;

        int counter = 0;
        while (true) {
            if (sum == k) {
                counter++;
                toNextL = true;
                toNextR = true;
            } else if (sum > k) {
                toNextL = true;
                if (l == r) {
                    toNextR = true;
                }
            } else {
                toNextR = true;
            }

            if (toNextR) {
                if (r < lastIndex) {
                    r++;
                    sum += nums[r];
                    toNextR = false;
                } else {
                    break;
                }
            }
            if (toNextL) {
                sum -= nums[l];
                l++;
                toNextL = false;
            }
        }

        return counter;
    }
}
