package yandex.course_1.lesson_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class c_FrequentWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> counter = new HashMap<>();
        String line = scanner.nextLine();

        while (line != null && !line.isBlank()) {
            String[] words = line.split(" ");
            for (String word : words) {
                counter.put(word, counter.getOrDefault(word, 0) + 1);
            }
            line = scanner.nextLine();
        }

        int max = -1;
        String word = "";
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                word = key;
            } else if (value == max) {
                word = word.compareTo(key) < 0 ? word : key;
            }
        }

        System.out.println(word);
    }
}
