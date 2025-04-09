package yandex.course_1.lesson_6;

import java.util.Scanner;

public class d_SpaceSettlement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //amount of modules
        int a = scanner.nextInt(); //1 side of module
        int b = scanner.nextInt();//2 side of module
        int w = scanner.nextInt(); // width of field
        int h = scanner.nextInt(); // height of field
        //(a+2d)(b+2d) - module with protection

        int l = 0;
        int r = Math.max(w, h) + 1;
        int wh = w * h;
        while (r - l > 1) {
            int m = (l + r) / 2;
            int module = (a + 2 * m) * (b + 2 * m);
            if (module * n <= wh) {
                l = m;
            } else {
                r = m;
            }
        }

        System.out.println(l);
    }

}
