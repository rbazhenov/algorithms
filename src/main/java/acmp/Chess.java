package acmp;

import java.util.Scanner;

/**
 * Головоломка про ферзей. 15%
 */
public class Chess {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int all = n * n;
        int empty = (n - 1) * 3 + 1;

        System.out.println(all - empty);
    }
}
