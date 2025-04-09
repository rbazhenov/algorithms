package yandex.course_1.lesson_3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class e_OpenCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> buttons = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        String n = scanner.nextLine();
        System.out.println(countNeededButtons(buttons, n));
    }

    public static int countNeededButtons(Set<Integer> buttons, String n) {
        Set<Integer> nSet = new HashSet<>();
        for (int i = 0; i < n.length(); i++) {
            nSet.add(Integer.parseInt(Character.toString(n.charAt(i))));
        }

        nSet.removeAll(buttons);
        return nSet.size();
    }
}
