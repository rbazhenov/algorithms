package yandex.course_1.lesson_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class h_Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        String str = scanner.nextLine();

        int[] ans = calcSubString(str, k);
        System.out.println(ans[0] + " " + ans[1]);
    }

    private static int[] calcSubString(String s, int k) {
        int start = 0;
        int longest = 0;
        int l = 0;
        Map<Character, Integer> cnt = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char currentChar = s.charAt(r);
            cnt.put(currentChar, cnt.getOrDefault(currentChar, 0) + 1);

            if (cnt.get(currentChar) > k) {
                while (s.charAt(l) != currentChar) {
                    cnt.put(s.charAt(l), cnt.get(s.charAt(l)) - 1);
                    l++;
                }
                cnt.put(s.charAt(l), cnt.get(s.charAt(l)) - 1);
                l++;
            }

            if (longest < r - l) {
                start = l;
                longest = r - l;
            }

        }

        //вернуть длину подстроки и первую пизицию index+1
        int[] ans = new int[2];
        ans[0] = longest + 1;
        ans[1] = start + 1;
        return ans;
    }
}
