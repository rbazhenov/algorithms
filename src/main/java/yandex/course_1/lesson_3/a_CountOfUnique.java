package yandex.course_1.lesson_3;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class a_CountOfUnique {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int unique = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet()).size();
        System.out.println(unique);
    }


}
