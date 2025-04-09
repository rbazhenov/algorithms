package yandex.course_1.lesson_1;

import java.util.Scanner;

//fu
/**
 * Корень из ax+b = c ==
 */
public class d_EquationWithRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        //x+2=-3
        if (c < 0) {
            System.out.println("NO SOLUTION");
        }



        else {
            int x = (c * c - b) / a;
            System.out.println(x);
        }
    }
}
