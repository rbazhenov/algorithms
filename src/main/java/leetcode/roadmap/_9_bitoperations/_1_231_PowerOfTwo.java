package leetcode.roadmap._9_bitoperations;

public class _1_231_PowerOfTwo {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(isPowerOfTwo(n));
    }

    //16 = 2^x
    //x = 4
    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }

        while (n > 1 && n % 2 == 0) {
            if (n == 2) {
                return true;
            }
            n >>= 1;
        }

        return false;
    }
}
