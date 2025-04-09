package leetcode.easy.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class _118_PascalsTriangle {

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i){
                    row.add(1);
                    continue;
                }
                List<Integer> prevRow = triangle.get(i - 1);
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            triangle.add(row);
        }

       return triangle;
    }

}
