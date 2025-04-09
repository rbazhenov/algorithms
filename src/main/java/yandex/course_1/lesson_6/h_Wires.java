package yandex.course_1.lesson_6;

import java.util.Arrays;
import java.util.Scanner;

public class h_Wires {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt(); //amount of pieces
        int[] wires = new int[n];
        for (int i = 0; i < n; i++) {
            wires[i] = scanner.nextInt();
        }

        Arrays.sort(wires);

        int l = 0;
        int r = wires[wires.length-1];
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            int amount = 0;
            for (int wire : wires) {
                amount += wire / m;
            }

            if (amount >= k) {
                l = m;
            } else {
                r = m;
            }
        }

        System.out.println(l);
    }
}
