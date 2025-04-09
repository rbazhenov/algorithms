package yandex.course_1.lesson_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class b_NumberAppearedWord2 {
    public static void main(String[] args) {
        String path = FileSystems.getDefault().getPath("").toAbsolutePath() + "/input.txt";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            Map<String, Integer> counter = new HashMap<>();
            String line = reader.readLine();

            while (line != null && !line.isBlank()) {
                String[] words = line.trim().split("\\s+");
                for (String w : words) {
                    System.out.print(counter.getOrDefault(w, 0) + " ");
                    counter.put(w, counter.getOrDefault(w, 0) + 1);
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Stupid yandex");
        }

    }

}
