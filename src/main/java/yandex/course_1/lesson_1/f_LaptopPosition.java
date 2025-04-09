package yandex.course_1.lesson_1;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//fu
public class f_LaptopPosition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        List<Integer> inputs = Stream.of(s).map(Integer::parseInt).collect(Collectors.toList());
        Integer a = inputs.get(0);
        Integer b = inputs.get(1);
        Integer c = inputs.get(2);
        Integer d = inputs.get(3);

        int A = Math.max(Math.max(a, b), Math.max(c,d));
        int B = Math.min(a, b);
        int C = Math.max(c, d);
        int D = Math.min(c, d);



    }


}
