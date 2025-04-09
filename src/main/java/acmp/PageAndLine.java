package acmp;

import java.util.Scanner;

/**
 * Строки в книге. 13%
 */
public class PageAndLine {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        int page;
        int line;
        if (k / n >= 1) {
            page = 1;
            line = n;
        } else {
            int ost = n % k;
            page = (n - ost) / k;
            page = ost == 0 ? page : page + 1;
            line = ost == 0 ? k : ost;
        }

        System.out.println(page + " " + line);
    }
}
