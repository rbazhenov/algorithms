package yandex.course_1.lesson_1;

import java.util.Scanner;

public class c_PhoneNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String replaceStr = "[^\\d]";
        String newNumber = longPhoneNumber(scanner.nextLine().replaceAll(replaceStr, ""));
        String a = longPhoneNumber(scanner.nextLine().replaceAll(replaceStr, ""));
        String b = longPhoneNumber(scanner.nextLine().replaceAll(replaceStr, ""));
        String c = longPhoneNumber(scanner.nextLine().replaceAll(replaceStr, ""));

        if (a.equals(newNumber)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        if (b.equals(newNumber)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        if (c.equals(newNumber)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static String longPhoneNumber(String s) {
        if (s.length() != 11) {
            s =  "8495" + s;
        }
        return "8" + s.substring(1);
    }
}
