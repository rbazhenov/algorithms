package leetcode.roadmap._1_bisearch;

public class _9_240_Search2dMatrixII {

    public static void main(String[] args) {
        //1 4 7 10
        //2 5 8 15
        //3 6 20 30
//        int[][] matrix = {{-5}};
        int[][] matrix = {{1, 4, 7, 10}, {2, 5, 8, 15}, {3, 6, 20, 30}};
        int target = 0;
//        int target = -5;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;

        while (column >= 0 && row <= matrix.length-1) {
            int current = matrix[row][column];
            if (current == target) {
                return true;
            } else if (current > target) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }
}
