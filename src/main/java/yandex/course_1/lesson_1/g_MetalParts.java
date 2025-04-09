package yandex.course_1.lesson_1;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class g_MetalParts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        List<Integer> inputs = Stream.of(s).map(Integer::parseInt).collect(Collectors.toList());
        Integer all = inputs.get(0);
        Integer blank = inputs.get(1);
        Integer part = inputs.get(2);

        int partsInBlank = blank / part;
        int extraInBlank = blank % part;

        int res = 0;
        while (all / blank > 0) {
            int blanks = all / blank;
            int newParts = partsInBlank * blanks;
            res = res + newParts;
            int extraInAll = all % blank;
            all = extraInAll + extraInBlank * newParts;
        }

        System.out.println(res);
    }
}
