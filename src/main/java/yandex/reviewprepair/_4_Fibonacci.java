package yandex.reviewprepair;

public class _4_Fibonacci {

    public static void main(String[] args) {
        int f = 10;
        System.out.println(fibonacciRecursive(f));
        System.out.println(fibonacciRecursiveWithMemo(f));
        System.out.println(fibonacciWithCycleAndArray(f));
        System.out.println(fibonacciWithCycle(f));
    }

    //2. = 1
    //3. 1 + 1 = 2
    //4 = 3
    private static int fibonacciRecursive(int f) {
        if (f < 2) {
            return f;
        }

        return fibonacciRecursive(f - 1) + fibonacciRecursive(f - 2);
    }

    private static int fibonacciRecursiveWithMemo(int f) {
        int[] memo = new int[f + 1];
        memo[1] = 1;
        return fibonacciRecursiveWithMemo(memo, f);
    }

    private static int fibonacciRecursiveWithMemo(int[] memo, int f) {
        if (f < 2) {
            return f;
        }

        if (memo[f] != 0) {
            return memo[f];
        }

        int res = fibonacciRecursiveWithMemo(memo, f - 1) + fibonacciRecursiveWithMemo(memo, f - 2);
        memo[f] = res;

        return res;
    }


    private static int fibonacciWithCycleAndArray(int x) {
        if (x < 2) {
            return x;
        }

        int[] nums = new int[x + 1];
        nums[1] = 1;

        for (int i = 2; i <= x; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }

        return nums[x];
    }

    //=5
    //2.0+1 = 1
    //3. 1+1 = 2
    //4. 2+1 = 3
    //5.
    private static int fibonacciWithCycle(int x) {
        if (x < 2) {
            return x;
        }

        int current = 1;
        int prev = 0;
        for (int i = 2; i <= x; i++) {
            int temp = prev;
            prev = current;
            current = prev + temp;
        }

        return current;
    }
}
