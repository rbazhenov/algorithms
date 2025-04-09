package acmp;

import java.util.Scanner;

public class A_Tests {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] split = scanner.nextLine().split(" ");
        int k = Integer.parseInt(scanner.nextLine());

        int res = 0;
        for (String s : split) {
            int ut = Integer.parseInt(s);
            res += Math.min(ut, k);
        }

        System.out.println(res);
    }
}
