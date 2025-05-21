package interview.yandex;

import java.util.HashMap;
import java.util.Map;

// Дана строка и натуральное число k.
// Требуется найти длину максимальной подстроки, содержащей не более k различных символов.
// Например:
//  s = "acaba", k = 2 -> 3 ("aca")
//  s = "aaa", k = 1 -> 3 ("aaa")
public class _07_05_MaxSubstringSequence {

    int LongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> cnt = new HashMap<>();
        int maxLen = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);

            while (cnt.size() > k) {
                char chLeft = s.charAt(j++);
                if (cnt.get(chLeft) > 1) {
                    cnt.put(chLeft, cnt.get(chLeft) - 1);
                } else {
                    cnt.remove(chLeft);
                }
            }

            maxLen = Math.max(maxLen, i - j + 1);
        }

        return maxLen;
    }
}
