package yandex.course_1.lesson_1;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//fu
public class e_Ambulance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        List<Integer> inputs = Stream.of(s).map(Integer::parseInt).collect(Collectors.toList());
        Integer k1 = inputs.get(0); // квартира 1зв
        Integer m = inputs.get(1); // кол-во этажей
        Integer k2 = inputs.get(2); // квартира 2зв
        Integer p2 = inputs.get(3); // поъезд 2зв
        Integer n2 = inputs.get(4); // этаж 2зв

        //сколько кв на этаже
        //89 20 41 1 11
        // 20 этажей, кв 41, подъезд 1, этаж 11
        //
        //
    }
}
