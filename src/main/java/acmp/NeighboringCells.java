package acmp;

import java.util.Scanner;

/**
 * Соседние клетки. 15%
 */
public class NeighboringCells {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = 8;

        boolean isUp = n <= x;
        boolean isDown = n > x * x - x;
        int row = n <= x ? 1 : n % x == 0 ? n / x : n / x + 1;
        boolean isLeft = n == 1 || (n > x && n == (row - 1) * x + 1);
        boolean isRight = n == x || n == row * x;

        String res = "";
        if (!isUp) {
            res = res + (n - x);
        }
        if (!isLeft) {
            res = res + " " + (n - 1);
        }
        if (!isRight) {
            res = res + " " + (n + 1);
        }
        if (!isDown) {
            res = res + " " + (n + x);
        }

        System.out.println(res.trim());
    }
}
