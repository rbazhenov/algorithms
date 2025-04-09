package leetcode.easy.dynamic;

/**
 * The Tribonacci sequence Tn is defined as follows:
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * <p>
 * Given n, return the value of Tn.
 */
public class _1137_NthTribonacciNumber {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(best(n));
    }

    public static int best(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i-3] + f[i-2] + f[i-1];
        }

        return f[n];
    }

    //my bad TimeoutOfMemory on leetcode with input 35
    public static int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }
}
