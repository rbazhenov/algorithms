package leetcode.medium;

import java.util.Arrays;

public class _443_StringCompression {

    public static void main(String[] args) {
        char [] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int compress = compress(chars);
        System.out.println(compress);
        System.out.println(Arrays.toString(Arrays.copyOfRange(chars, 0, compress)));
    }

    public static int compress(char[] chars) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            cnt++;

            if (i == chars.length - 1 || cur != chars[i + 1]) {
                sb.append(cur);
                if (cnt > 1) {
                    sb.append(cnt);
                }
                cnt = 0;
            }
        }

        int len = 0;
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
            len++;
        }

        return len;
    }

}
