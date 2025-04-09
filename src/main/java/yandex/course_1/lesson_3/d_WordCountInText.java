package yandex.course_1.lesson_3;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class d_WordCountInText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        boolean flag = true;
        while (flag) {
            String line = scanner.nextLine();
            if (line.isBlank()) {
                flag = false;
            }

            text.append(line);
        }

        System.out.println(countWord(text.toString()));
    }

    public static int countWord(String text) {
        String replacedNonLetters = text.replaceAll("[^A-Za-z0-9]", " ");
        String replacedBlanks = replacedNonLetters.trim().replaceAll(" +", " ");
        Set<String> set = Stream.of(replacedBlanks.split(" "))
//                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        return set.size();
    }
}
