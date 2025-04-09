package yandex.course_1.lesson_3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class h_AngryPigs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            xy[i][0] = Integer.parseInt(s[0]);
            xy[i][1] = Integer.parseInt(s[1]);
        }

        System.out.println(minShoots(xy));
    }

    public static int minShoots(int[][] xy) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < xy.length; i++) {
            set.add(xy[i][0]);
        }
        return set.size();
    }
}
