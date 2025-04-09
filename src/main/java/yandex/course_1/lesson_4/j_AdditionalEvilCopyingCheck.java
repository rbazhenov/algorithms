package yandex.course_1.lesson_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class j_AdditionalEvilCopyingCheck {
    public static void main(String[] args) {

        //Идентификатор - Все последовательности из латинских букв, цифр и знаков подчеркивания, которые не являются ключевыми словами
        // и содержат хотя бы один символ, не являющийся цифрой, могут быть идентификаторами.
        // При этом в некоторых языках идентификаторы могут начинаться с цифры, а в некоторых - нет


        Map<String, List<Integer>> identifiers = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"))) {
            String[] s1 = reader.readLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            boolean isRegisterSense = s1[1].equals("yes");
            boolean hasDigitStart = s1[2].equals("yes");

            Set<String> keyWords = getKeyWords(reader, n, isRegisterSense);
            identifiers = calcIdentifiers(reader, keyWords, isRegisterSense, hasDigitStart);
        } catch (IOException e) {
        }

        print(identifiers);
    }

    private static void print(Map<String, List<Integer>> identifiers) {
        int max = 0;
        for (Map.Entry<String, List<Integer>> entry : identifiers.entrySet()) {
            Integer count = entry.getValue().get(1);
            if (count > max) {
                max = count;
            }
        }

        List<String> mostCommons = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : identifiers.entrySet()) {
            if (entry.getValue().get(1) == max) {
                mostCommons.add(entry.getKey());
            }
        }

        String result = "";
        int minAppearance = identifiers.size();
        for (String mostCommon : mostCommons) {
            Integer appearance = identifiers.get(mostCommon).get(0);
            if (appearance < minAppearance) {
                minAppearance = appearance;
                result = mostCommon;
            }
        }
        System.out.println(result);
    }

    private static Map<String, List<Integer>> calcIdentifiers(BufferedReader reader,
                                                              Set<String> keyWords,
                                                              boolean isRegisterSense,
                                                              boolean hasDigitStart) throws IOException {
        Map<String, List<Integer>> identifiers = new HashMap<>();
        String line = reader.readLine().strip();
        int appearance = 0;
        while (line != null && !line.isBlank()) {
            List<String> wordsInLine = prepareLine(line);
            for (int i = 0; i < wordsInLine.size(); i++) {
                appearance = appearance + i;
                String word = wordsInLine.get(i);
                if (word.isEmpty()) {
                    continue;
                }

                if (isIdentifier(word, keyWords, isRegisterSense, hasDigitStart)) {
                    List<Integer> counter;
                    word = isRegisterSense ? word : word.toLowerCase();
                    if (identifiers.containsKey(word)) {
                        counter = identifiers.get(word);
                        Integer count = counter.get(1) + 1;
                        counter.remove(1);
                        counter.add(count);
                    } else {
                        counter = new ArrayList<>();
                        counter.add(appearance);
                        counter.add(1);
                    }
                    identifiers.put(word, counter);

                }
            }

            line = reader.readLine();
        }

        return identifiers;
    }

    private static List<String> prepareLine(String line) {
        List<String> result = new ArrayList<>();
        for (String str : line.split(" ")) {
            if (!str.isEmpty()) {
                String[] split = str.replaceAll("[^\\da-zA-Z_]", " ").split(" ");
                for (String word : split) {
                    if (!word.isEmpty()) {
                        result.add(word);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isIdentifier(String word, Set<String> keyWords,
                                        boolean isRegisterSense,
                                        boolean hasDigitStart) {
        if (word.isEmpty()) {
            return false;
        }
        String wordToCompare = isRegisterSense ? word : word.toLowerCase();
        if (!keyWords.contains(wordToCompare)) {
            return (hasDigitStart || !Character.isDigit(word.charAt(0))) &&
                    (!hasDigitStart || !Character.isDigit(word.charAt(0)) || word.length() != 1);
        }
        return false;
    }

    private static Set<String> getKeyWords(BufferedReader reader, int n, boolean isRegisterSense) throws IOException {
        Set<String> keyWords = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String keyWord = reader.readLine();
            if (!isRegisterSense) {
                keyWords.add(keyWord.toLowerCase());
            } else {
                keyWords.add(keyWord);
            }
        }

        return keyWords;
    }

}
