package yandex.course_1.lesson_5;

import java.util.Scanner;

public class i_Robot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();

        System.out.println(useWindow(k, s));
    }

    //best окно
    private static int useWindow(int k, String s) {
        int prevLen = 0;
        int ans = 0;
        for (int i = k; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - k)) {
                prevLen++;
                ans += prevLen;
            } else {
                prevLen = 0;
            }
        }

        return ans;
    }

    private static int countWays(int k, String s) {
        int r = 0;
        int lastIndex = s.length() - 1;
        int ans = 0;
        for (int l = 0; l < s.length(); l++) {
            // fill robot's capacity and see next
            while (r < lastIndex && r - l < k) {
                r++;
            }

            int i = l;
            while (s.charAt(i) == s.charAt(r) && l < lastIndex) {
                ans++;
                if (r < lastIndex) {
                    r++;
                }
                i++;
            }
        }

        return ans;
    }
}
