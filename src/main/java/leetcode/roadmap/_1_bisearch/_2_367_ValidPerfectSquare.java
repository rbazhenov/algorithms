package leetcode.roadmap._1_bisearch;

public class _2_367_ValidPerfectSquare {
    public static void main(String[] args) {
        int num = 808201;
        System.out.println(isPerfectSquare(num));
    }

    public static boolean isPerfectSquare(int num) {
        long l = 0;
        long r = num;
        while (l < r) {
            long m = l + (r - l) / 2;
            if (m * m < num) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l * l == num;
    }
}
