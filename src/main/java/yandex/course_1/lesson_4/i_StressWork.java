package yandex.course_1.lesson_4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class i_StressWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Set<String>> dict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String key = word.toLowerCase();
            Set<String> words;
            if (!dict.containsKey(key)) {
                words = new HashSet<>();
            } else {
                words = dict.get(key);
            }
            words.add(word);
            dict.put(word.toLowerCase(), words);
        }

        String[] wordsToCheck = scanner.nextLine().split(" ");
        int mistakes = 0;
        for (String word : wordsToCheck) {
            Set<String> dicValues = dict.get(word.toLowerCase());

            if (dicValues != null) {
                if (!dicValues.contains(word)) {
                    mistakes++;
                }
            } else {
                if (!hasOnlyOneStress(word)) {
                    mistakes++;
                }
            }
        }

        System.out.println(mistakes);
    }

    private static boolean hasOnlyOneStress(String word) {
        int stressCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) {
                stressCount++;
            }

            if (stressCount > 1) {
                return false;
            }
        }

        return stressCount == 1;
    }
}
