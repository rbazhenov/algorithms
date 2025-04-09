package yandex.course_1.lesson_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class b_NumberAppearedWord {
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"))) {
            Map<String, Integer> dic = new HashMap<>();
            String line = reader.readLine();
            StringBuilder result = new StringBuilder();

            while (line != null) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    boolean isLineEnd = i == line.length() - 1;
                    if (isLineEnd) {
                        builder.append(symbol);
                    }
                    if ((symbol == ' ' && builder.length() != 0) || isLineEnd) {
                        String word = builder.toString();
                        if (dic.containsKey(word)) {
                            dic.put(word, dic.get(word) + 1);
                        } else {
                            dic.put(word, 0);
                        }

                        result.append(dic.get(word));
                        if (i < line.length() - 1) {
                            result.append(' ');
                        }
                        builder = new StringBuilder();
                    } else {
                        builder.append(symbol);
                    }
                }
                line = reader.readLine();
                if (line != null) {
                    result.append(' ');
                }
            }

            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

}
