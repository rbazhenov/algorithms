package yandex.course_1.lesson_3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class f_AlienGenome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(similarity(a, b));
    }

    public static int similarity(String a, String b) {
        Set<String> aSet = new HashSet<>();
        for (int i = 0; i < a.length() - 1; i++) {
            aSet.add(a.substring(i, i + 2));
        }

        Set<String> bSet = new HashSet<>();
        for (int i = 0; i < b.length() - 1; i++) {
            bSet.add(a.substring(i, i + 2));
        }

        int aSize = aSet.size();
        aSet.removeAll(bSet);
        return aSize - aSet.size();
    }

}
