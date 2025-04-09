package leetcode.easy;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 * <p>
 * You must not use any built-in exponent function or operator.
 * <p>
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */
public class _69_Sqrt {

    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == x/mid) {
                return mid;
            } else if (mid > x/mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
