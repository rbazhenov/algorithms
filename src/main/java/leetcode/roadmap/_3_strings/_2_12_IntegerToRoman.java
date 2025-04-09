package leetcode.roadmap._3_strings;

import java.util.Stack;

public class _2_12_IntegerToRoman {
    public static void main(String[] args) {
//        int num = 58;
        int num = 3749;
//        int num = 5;
        System.out.println(intToRomanBest(num));
    }

    public static String intToRomanBest(int num) {
        final int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < val.length; i++) {
            if (num==0){
                break;
            }
            while (num>=val[i]){
                ans.append(rom[i]);
                num -= val[i];
            }
        }

        return ans.toString();
    }

    public static String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        str.append(num);
        Stack<String> stack = new Stack<>();
        for (int i = str.length() - 1, delimiter = 10; i >= 0; i--, delimiter *= 10) {
            int n = num % delimiter;
            String roman = calcRoman(n);
            stack.add(roman);
            str.setCharAt(i, '0');
            num = Integer.parseInt(str.toString());
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.empty()) {
            ans.append(stack.pop());
        }

        return ans.toString();
    }

    private static String calcRoman(int num) {
        StringBuilder builder = new StringBuilder();

        //1-9
        if (num < 10) {
            if (num < 4) {
                appendRoman(builder, "I", num);
            } else if (num == 4) {
                appendRoman(builder, "IV", 1);
            } else if (num >= 5 && num < 9) {
                appendRoman(builder, "V", 1);
                appendRoman(builder, "I", num - 5);
            } else if (num == 9) {
                appendRoman(builder, "IX", 1);
            }
        }

        //10-99
        if (num >= 10 && num < 100) {
            if (num < 40) {
                appendRoman(builder, "X", num / 10);
            } else if (num == 40) {
                appendRoman(builder, "XL", 1);
            } else if (num >= 50 && num < 90) {
                appendRoman(builder, "L", 1);
                appendRoman(builder, "X", (num - 50) / 10);
            } else if (num == 90) {
                appendRoman(builder, "XC", 1);
            }
        }

        //100-999
        if (num >= 100 && num < 1000) {
            if (num < 400) {
                appendRoman(builder, "C", num / 100);
            } else if (num == 400) {
                appendRoman(builder, "CD", 1);
            } else if (num >= 500 && num < 900) {
                appendRoman(builder, "D", 1);
                appendRoman(builder, "C", (num - 500) / 100);
            } else if (num == 900) {
                appendRoman(builder, "CM", 1);
            }
        }

        if (num >= 1000 && num < 4000) {
            appendRoman(builder, "M", num / 1000);
        }


        return builder.toString();
    }

    private static String appendRoman(StringBuilder builder, String roman, int times) {
        builder.append(String.valueOf(roman).repeat(Math.max(0, times)));
        return builder.toString();
    }
}
