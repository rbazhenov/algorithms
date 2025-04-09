package yandex.course_2.lesson_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class _1_Histogram {
    public static void main(String[] args) {
        Map<Character, Integer> cnt = new TreeMap<>();

//        String path = FileSystems.getDefault().getPath("").toAbsolutePath() + "/input.txt";
        String path = _1_Histogram.class.getResource("input.txt").getPath();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line = reader.readLine();
            while (line != null && !line.isBlank()) {
                for (char ch : line.toCharArray()) {
                    if (ch != ' ') {
                        cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {

        }

        String[] histogram = histogram(cnt);
        for (String s : histogram) {
            System.out.println(s);
        }

    }

    private static String[] histogram(Map<Character, Integer> cnt) {
        int max = cnt.values().stream().mapToInt(i -> i).max().getAsInt();
        String[] result = new String[max];
        for (int i = max; i > 0; i--) {
            StringBuilder row = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : cnt.entrySet()) {
                if (entry.getValue() >= i) {
                    row.append("#");
                } else {
                    row.append(" ");
                }
            }
            result[max-i] = row.toString();
        }

        return result;
    }
}
