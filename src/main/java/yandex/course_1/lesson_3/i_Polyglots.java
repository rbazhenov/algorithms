package yandex.course_1.lesson_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class i_Polyglots {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> popularMap = new HashMap<>();
        Set<String> languages = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < m; j++) {
                String language = scanner.nextLine();
                languages.add(language);
                popularMap.put(language, popularMap.getOrDefault(language, 0) + 1);
            }
        }

        Set<String> populars = new HashSet<>();
        for (Map.Entry<String, Integer> entry : popularMap.entrySet()) {
            if (entry.getValue() == n){
                populars.add(entry.getKey());
            }
        }

        System.out.println(populars.size());
        populars.forEach(System.out::println);

        System.out.println(languages.size());
        languages.forEach(System.out::println);
    }

}
