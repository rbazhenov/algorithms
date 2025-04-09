package yandex.course_1.lesson_4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class d_Keyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int buttons = Integer.parseInt(scanner.nextLine());

        int[] buttonsHealth = new int[buttons + 1];
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(i -> buttonsHealth[atomicInteger.getAndIncrement()] = i);
        int pressTimes = Integer.parseInt(scanner.nextLine());
        List<Integer> clickSequence = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        serviceability(buttonsHealth, clickSequence).forEach(System.out::println);
    }

    public static List<String> serviceability(int[] reserve, List<Integer> sequence) {
        sequence.forEach(button -> reserve[button]--);
        return Arrays.stream(Arrays.copyOfRange(reserve, 1, reserve.length))
                .mapToObj(health -> health > -1 ? "NO" : "YES")
                .collect(Collectors.toList());
    }
}
