package yandex.course_1.lesson_8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class j_LevelNumber {

    private static Map<String, String> child2p = new HashMap<>();
    private static Set<String> persons = new TreeSet<>();
    private static Map<String, Integer> levels = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n - 1; i++) {
            String[] split = scanner.nextLine().split(" ");
            String child = split[0];
            String parent = split[1];

            child2p.put(child, parent);

            persons.add(child);
            persons.add(parent);
        }

        for (String person : persons) {
            levels.put(person, height(person));
            System.out.println(person + " " + levels.get(person));
        }
    }

    private static int height(String person) {
        if (!child2p.containsKey(person)) {
            return 0;
        }

        return 1 + height(child2p.get(person));
    }
}
