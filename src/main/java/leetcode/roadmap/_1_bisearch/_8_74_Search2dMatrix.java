package leetcode.roadmap._1_bisearch;

public class _8_74_Search2dMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix = {{1},{3},{5}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int lr = 0;
        int rr = matrix.length - 1;
        while (lr < rr) {
            int mr = lr + (rr - lr) / 2;
            int[] row = matrix[mr];
            if (target >= row[0] && target <= row[row.length - 1]) {
                lr = mr;
                break;
            } else if (target < row[0]) {
                rr = mr;
            } else if (target > row[row.length - 1]) {
                lr = mr + 1;
            }
        }

        int[] row = matrix[lr];
        int l = 0;
        int r = row.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (row[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return matrix[lr][l] == target;
    }
}
