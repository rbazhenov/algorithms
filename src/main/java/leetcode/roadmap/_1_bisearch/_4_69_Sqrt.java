package leetcode.roadmap._1_bisearch;

public class _4_69_Sqrt {
    public static void main(String[] args) {
        int x = 1;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long l = 1;
        long r = x;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return (int) r;
    }
}
