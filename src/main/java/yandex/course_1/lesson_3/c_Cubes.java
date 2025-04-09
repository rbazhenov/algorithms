package yandex.course_1.lesson_3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class c_Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nm = scanner.nextLine().split(" ");
        Integer n = Integer.parseInt(nm[0]);
        Integer m = Integer.parseInt(nm[1]);

        Set<Integer> anyaCubes = new HashSet<>(n);
        Set<Integer> boryaCubes = new HashSet<>(m);

        for (int i = 0; i < n; i++) {
            anyaCubes.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < m; i++) {
            boryaCubes.add(Integer.parseInt(scanner.nextLine()));
        }

        Set<Integer> temp = new HashSet<>(Set.copyOf(anyaCubes));
        temp.removeAll(boryaCubes);
        Set<Integer> commonCubes = new HashSet<>(Set.copyOf(anyaCubes));
        commonCubes.removeAll(temp);

        //1. count of unique
        System.out.println(commonCubes.size());

        //2. unique values
        String uniqueValues = commonCubes.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(uniqueValues);


        //3. extra anya's count
        System.out.println(anyaCubes.size() - commonCubes.size());

        //4. extra anya's values
        anyaCubes.removeAll(commonCubes);
        String anyaExtraValues = anyaCubes.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(anyaExtraValues);

        //5. extra borya's count
        System.out.println(boryaCubes.size() - commonCubes.size());

        //6. extra borya's values
        boryaCubes.removeAll(commonCubes);
        String boryaExtraValues = boryaCubes.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(boryaExtraValues);
    }


}
