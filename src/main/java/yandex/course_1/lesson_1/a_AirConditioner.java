package yandex.course_1.lesson_1;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class a_AirConditioner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        List<Integer> temperatures = Stream.of(s).map(Integer::parseInt).collect(Collectors.toList());
        String mode = scanner.nextLine();

        Integer tRoom = temperatures.get(0);
        Integer tCond = temperatures.get(1);
        Integer result = null;
        if (mode.equalsIgnoreCase("freeze")) {
            result = tRoom > tCond ? tCond : tRoom;
        } else if (mode.equalsIgnoreCase("heat")) {
            result = tRoom > tCond ? tRoom : tCond;
        } else if (mode.equalsIgnoreCase("auto")) {
            result = tCond;
        } else if (mode.equalsIgnoreCase("fan")) {
            result = tRoom;
        }

        System.out.println(result);
    }

}
