package yandex.course_1.lesson_7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class a_ObservationOfStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//amount of students
        int m = scanner.nextInt();//amount of observers
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        System.out.println(calc(n, a, b));
    }

    private static int calc(int n, int[] a, int[] b) {
        int len = a.length;
        int[][] events = new int[len * 2][2];

        for (int i = 0, j = 0; i < len; i++) {
            events[j][0] = a[i];
            events[j][1] = -1;
            j++;
            events[j][0] = b[i];
            events[j][1] = 1;
            j++;
        }

        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));

        int ans = 0;
        int watch = 0;
        int lInd = 0;//левый студент без наблюдения
        for (int[] event : events) {
            if (watch == 0) {
                ans += Math.max(event[0] - lInd, 0);
            }

            if (event[1] == -1) {
                watch += 1;
            }
            if (event[1] == 1) {
                watch -= 1;
            }

            //закончился неприрывный отрезок наблюдения. мб нескольких наблюдателей
            //указываем следующего студента без наблюдения
            if (watch == 0) {
                lInd = event[0] + 1;
            }
        }

        ans += n - lInd;
        return ans;
    }
}
