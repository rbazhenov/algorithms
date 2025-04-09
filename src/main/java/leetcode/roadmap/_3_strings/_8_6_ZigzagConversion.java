package leetcode.roadmap._3_strings;

import java.util.ArrayList;
import java.util.List;

public class _8_6_ZigzagConversion {
    public static void main(String[] args) {
//        String s = "ABCDE";
        String s = "PAYPALISHIRING";
//        int numRows = 4;
        int numRows = 4;
        System.out.println(convertBest(s, numRows));
    }

    public static String convertBest(String s, int numRows) {
        // Edge case: If there's only one row, the result is the same as the input string
        if (numRows == 1) {
            return s;
        }

        // List of lists to store characters row-wise
        List<List<Character>> zigzagRows = new ArrayList<>();

        // Initialize each row as an empty list
        for (int row = 0; row < numRows; row++) {
            zigzagRows.add(new ArrayList<>());
        }

        int index = 0; // Pointer to traverse the input string
        int length = s.length();

        while (index < length) {
            // Traverse downwards in the zigzag pattern
            for (int row = 0; row < numRows && index < length; row++) {
                zigzagRows.get(row).add(s.charAt(index++));
            }

            // Traverse diagonally upwards in the zigzag pattern
            for (int row = numRows - 2; row > 0 && index < length; row--) {
                zigzagRows.get(row).add(s.charAt(index++));
            }
        }

        // Build the final result by appending characters from each row
        StringBuilder result = new StringBuilder();
        for (List<Character> rowList : zigzagRows) {
            for (char c : rowList) {
                result.append(c);
            }
        }

        return result.toString();
    }

    //3 = 3-2 = 1
    //P   A   H   N
    //A P L S I I G
    //Y   I   R
    //PAHNAPLSIIGYIR

    //4 = 4- 2 = 2
    //P     I    N
    //A   L S  I G
    //Y A   H R
    //P     I
    //PINALSIGYAHRPI

    //5 = 5 - 2 = 3
    //P       H
    //A     S I
    //Y   I   R
    //P L     I G
    //A       N

    //6=6-2=4
    //P          R
    //A        I I
    //Y      H   N
    //P    S     G
    //A  I
    //L
    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        int zigs = numRows - 2; //в каждой по 1 букве, а потом numrows
        int columns = calcColumns(zigs, numRows, s.length());
        char[][] arr = new char[columns][numRows];

        int i = 0;
        int cnt = 0;
        int col = 0;
        //целый столбик, потом rows-2 столбиков по 1 букве
        while (i < s.length()) {
            if (cnt == numRows) {
                cnt--;
                while (cnt > 1 && i<s.length()) {
                    arr[++col][--cnt] = s.charAt(i++);
                }
                col++;
                cnt--;
            } else {
                arr[col][cnt++] = s.charAt(i++);
            }

        }

        return joining(arr, numRows);
    }

    private static String joining(char[][] arr, int numRows) {
        StringBuilder join = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (char[] chars : arr) {
                if (chars[i] != 0) {
                    join.append(chars[i]);
                }
            }
        }
        return join.toString();
    }

    private static int calcColumns(int zigs, int rows, int strLen) {
        int columns = 0;
        for (int i = 0; i < strLen; i += rows + zigs) {
            columns += 1 + zigs;
        }

        return columns;
    }
}
