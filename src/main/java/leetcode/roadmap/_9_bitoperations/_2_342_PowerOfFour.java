package leetcode.roadmap._9_bitoperations;

public class _2_342_PowerOfFour {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(isPowerOfFour(n));
    }

    public static boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }

        if (n >= 4 && n % 4 == 0) {
            return isPowerOfFour(n >> 2);
        }

        return false;
    }


}
