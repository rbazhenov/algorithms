package yandex.course_1.lesson_3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class g_Turtles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] ab = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            ab[i][0] = Integer.parseInt(s[0]);
            ab[i][1] = Integer.parseInt(s[1]);
        }

        System.out.println(countTruth(ab));
    }

    public static int countTruth(int[][] ab) {
        Set<String> setOfTruth = new HashSet<>();
        for (int i = 0; i < ab.length; i++) {
            int a = ab[i][0];
            int b = ab[i][1];
            if ((a >= 0 && b >= 0) && ((a + b) == ab.length - 1)) {
                setOfTruth.add(a + "" + b);
            }
        }

        return setOfTruth.size();
    }
}
