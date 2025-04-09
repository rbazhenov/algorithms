package leetcode.easy.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 */
public class _119_PascalsTriangleII {

    public static void main(String[] args) {
        int numRows = 3;
        System.out.println(getRow(numRows));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
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

        return triangle.get(triangle.size()- 1);
    }
}
