package yandex.course_1.lesson_6;

import java.util.Scanner;

public class e_ImprovedCorrectness {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();//amount 2
        long b = scanner.nextLong();//amount 3
        long c = scanner.nextLong();//amount 4
        //(2a+3b+4c)/a+b+c = avg

        long gradeSum = 2 * a + 3 * b + 4 * c;
        long gradeCount = a + b + c;
        if (Math.round((double) gradeSum / gradeCount) >= 4) {
            System.out.println(0);
        } else {
            long l = 0;
            long r = 4 * (a + b + c) + 1;
            while (r - l > 1) {
                long m = (r + l) / 2;
                gradeSum = 2 * a + 3 * b + 4 * c + 5 * m;
                gradeCount = a + b + c + m;
                if (Math.round((double) gradeSum / gradeCount) >= 4) {
                    r = m;
                } else {
                    l = m;
                }
            }

            System.out.println(r);
        }
    }
}
