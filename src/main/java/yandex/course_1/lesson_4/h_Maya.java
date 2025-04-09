package yandex.course_1.lesson_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class h_Maya {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int wLen = Integer.parseInt(split[0]);
        int sLen = Integer.parseInt(split[1]);

        Map<Character, Integer> wDict = makeDict(scanner.nextLine());
        String inputStr = scanner.nextLine();
        Map<Character, Integer> sDict = makeDict(inputStr.substring(0, wLen));

        int matched = matchDict(wDict, sDict);
        int counter = matched == wLen ? 1 : 0;

        for (int i = wLen; i < sLen; i++) {
            matched += modifCounter(sDict, wDict, inputStr.charAt(i - wLen), -1);
            matched += modifCounter(sDict, wDict, inputStr.charAt(i), 1);

            if (matched == wLen) {
                counter++;
            }
        }

        System.out.println(counter);
    }

    public static int modifCounter(Map<Character, Integer> sDict, Map<Character, Integer> wDict, char ch, int count) {
        int ans = 0;
        sDict.put(ch, sDict.getOrDefault(ch, 0));
        if (sDict.get(ch).equals(wDict.get(ch))) {
            ans = -1;
        }
        sDict.put(ch, sDict.get(ch) + count);
        if (sDict.get(ch).equals(wDict.get(ch))) {
            ans = 1;
        }
        return ans;
    }

    private static Map<Character, Integer> makeDict(String s) {
        Map<Character, Integer> dict = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            dict.put(key, dict.getOrDefault(key, 0) + 1);
        }

        return dict;
    }

    private static int matchDict(Map<Character, Integer> dict1, Map<Character, Integer> dict2) {
        int matches = 0;
        for (Map.Entry<Character, Integer> entry : dict1.entrySet()) {
            Character key = entry.getKey();
            if (dict2.containsKey(key) && entry.getValue().equals(dict2.get(key))) {
                matches++;
            }
        }

        return matches;
    }
}
