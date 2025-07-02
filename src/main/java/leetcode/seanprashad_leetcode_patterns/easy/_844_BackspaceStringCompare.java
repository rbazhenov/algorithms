package leetcode.seanprashad_leetcode_patterns.easy;

public class _844_BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(backspaceCompare(s,t));
    }

    public static boolean backspaceCompare(String s, String t) {
        char backspace = '#';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == backspace && sb.length()>0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (ch != backspace) {
                sb.append(ch);
            }
        }

        StringBuilder tb = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch == backspace && tb.length() > 0) {
                tb.deleteCharAt(tb.length() - 1);
            }
            if (ch != backspace){
                tb.append(ch);
            }
        }

        return sb.toString().contentEquals(tb);
    }
}
