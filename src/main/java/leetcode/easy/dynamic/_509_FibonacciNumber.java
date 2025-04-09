package leetcode.easy.dynamic;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is, <p>
 * F(0) = 0, F(1) = 1 <p>
 * F(n) = F(n - 1) + F(n - 2), for n > 1. <p>
 * Given n, calculate F(n).
 */
public class _509_FibonacciNumber {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
