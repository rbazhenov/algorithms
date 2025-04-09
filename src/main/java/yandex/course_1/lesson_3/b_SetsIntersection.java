package yandex.course_1.lesson_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class b_SetsIntersection {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"))) {
            set1 = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toSet());
            set2 = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toSet());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        Set<Integer> uniqueAndOrdered = uniqueAndOrdered(set1, set2);
        StringJoiner joiner = new StringJoiner(" ");
        for (Integer num : uniqueAndOrdered) {
            joiner.add(String.valueOf(num));
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("output.txt"))) {
            writer.write(joiner.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Set<Integer> uniqueAndOrdered(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> temp = new HashSet<>(Set.copyOf(set1));
        set1.removeAll(set2);
        temp.removeAll(set1);

        return temp;
    }
}
