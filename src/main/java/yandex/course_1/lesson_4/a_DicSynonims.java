package yandex.course_1.lesson_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class a_DicSynonims {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> dic = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String [] words = scanner.nextLine().split(" ");
            dic.put(words[0], words[1]);
            dic.put(words[1], words[0]);
        }

        System.out.println(dic.get(scanner.nextLine()));
    }
}
