package yandex.course_1.lesson_1;

import java.util.Arrays;
import java.util.Scanner;

public class i_PrisonerOfIfCastle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int d = Integer.parseInt(scanner.nextLine());
        int e = Integer.parseInt(scanner.nextLine());

        int hMax = Math.max(d, e);
        int hMin = Math.min(d, e);

        int[] arrABC = {a, b, c};
        Arrays.sort(arrABC);
        int kMin = arrABC[0];
        int kMid = arrABC[1];

        if (hMin < kMin || hMax < kMid) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
