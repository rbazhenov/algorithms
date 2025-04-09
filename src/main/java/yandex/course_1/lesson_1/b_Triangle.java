package yandex.course_1.lesson_1;

import java.util.Scanner;

public class b_Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

//        if (a != c || b != c) { //(a + b) > c and (a + c) > b and (b + c) > a:
        if ((a+b) > c && (a+c) > b && (b+c) > a){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
