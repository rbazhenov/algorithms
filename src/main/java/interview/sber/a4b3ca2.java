package interview.sber;

/**
 * aaaabbbcaa -> a4b3ca2
 * a -> a
 * bba -> b2a
 */
public class a4b3ca2 {

    public static void main(String[] args) {
        String s = "aaaabbbcaa";
//        String s = "a";
//        String s = "bba";
        System.out.println(convert(s));
        System.out.println(calc(s));
    }

    private static String calc(String s) {
        int cnt = 1;
        StringBuilder builder = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (i < len - 1 && ch == s.charAt(i + 1)) {
                cnt++;
            } else {
                builder.append(ch);
                if (cnt > 1) {
                    builder.append(cnt);
                }
                cnt = 1;
            }
        }

        return builder.toString();
    }

    private static String convert(String s) {
        if (s.length() < 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            char nextCh = s.charAt(i + 1);

            if (ch == nextCh) {
                cnt++; // 2,
            } else {
                sb.append(ch); // a
                if (cnt > 1) {
                    sb.append(cnt); // 4
                }
                cnt = 1;
            }

            if (i + 2 == s.length()) {
                //последний повторяющийся
                if (ch == nextCh) {
                    sb.append(ch);
                    sb.append(cnt);
                } else {
                    //последний отличный
                    sb.append(nextCh);
                }
            }
        }

        return sb.toString();
    }

}
