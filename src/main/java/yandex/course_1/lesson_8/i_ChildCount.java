package yandex.course_1.lesson_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class i_ChildCount {

    private static Map<String, List<String>> p2children = new HashMap<>();
    private static Set<String> persons = new TreeSet<>();
    private static Map<String, Integer> cnt = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n - 1; i++) {
            String[] split = scanner.nextLine().split(" ");
            String child = split[0];
            String parent = split[1];

            p2children.putIfAbsent(parent, new ArrayList<>());
            p2children.get(parent).add(child);

            persons.add(child);
            persons.add(parent);
        }


        for (String person : persons) {
            cnt.put(person, countChildren(person));

            System.out.println(person + " " + cnt.get(person));
        }
    }

    private static int countChildren(String person) {
        if (cnt.containsKey(person)) {
            return cnt.get(person);
        }

        List<String> children = p2children.get(person);
        if (children == null || children.isEmpty()) {
            return 0;
        }

        int count = children.size();
        for (String child : children) {
            count += countChildren(child);
        }

        return count;
    }

}
