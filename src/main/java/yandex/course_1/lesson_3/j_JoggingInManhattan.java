package yandex.course_1.lesson_3;

import java.util.Scanner;

public class j_JoggingInManhattan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tdn = scanner.nextLine().split(" ");
        int t = Integer.parseInt(tdn[0]);
        int d = Integer.parseInt(tdn[1]);
        int n = Integer.parseInt(tdn[2]);

        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] xyStr = scanner.nextLine().split(" ");
            xy[i][0] = Integer.parseInt(xyStr[0]);
            xy[i][1] = Integer.parseInt(xyStr[1]);
        }

        
    }


}
