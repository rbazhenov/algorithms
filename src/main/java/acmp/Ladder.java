package acmp;

import java.util.Scanner;

/**
 * Лестница. 14%
 */
public class Ladder {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        int max = 0;
        int use = 0;
        while (max < k - use){
            max = max + 1;
            use = use + max;
        }

        System.out.println(max);
    }
}
