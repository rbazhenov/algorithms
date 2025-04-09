package yandex.course_2.lesson_2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _17_DrunkGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> cardsA = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(cardsA::addLast);

        Deque<Integer> cardsB = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(cardsB::addLast);

        play(cardsA, cardsB);
    }

    private static void play(Deque<Integer> cardsA, Deque<Integer> cardsB) {
        int cnt = 0;
        while (!cardsA.isEmpty() && !cardsB.isEmpty() && cnt < 1000000) {
            Integer popA = cardsA.removeFirst();
            Integer popB = cardsB.removeFirst();
            if (battle(popA, popB) == -1) {
                cardsA.addLast(popA);
                cardsA.addLast(popB);
            } else {
                cardsB.addLast(popA);
                cardsB.addLast(popB);
            }

            cnt++;
        }

        if (cardsA.isEmpty()) {
            System.out.println("second" + " " + cnt);
        } else if (cardsB.isEmpty()) {
            System.out.println("first" + " " + cnt);
        } else {
            System.out.println("botva");
        }

    }

    //-1 won a, 1 won b
    private static int battle(int a, int b) {
        if (a == 0 && b == 9) {
            return -1;
        } else if (b == 0 && a == 9) {
            return 1;
        }

        if (a > b) {
            return -1;
        } else {
            return 1;
        }
    }
}
