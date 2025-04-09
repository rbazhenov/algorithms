package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class _70_ClimbingStairs {

    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        int n = 44;
        for (int i = 0; i <= n; i++) {
            System.out.println("i = " + i + ", feb = " + climbStairsMap(i));
        }
        System.out.println("Time = " + (System.currentTimeMillis() - before));
    }

    //1
    public static int climbStairsRec(int n) {
        if (n <= 1) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //2.1
    public static int climbStairsMap(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairsMapRec(n, memo);
    }
    //2.2
    public static int climbStairsMapRec(int n, Map<Integer, Integer> memo) {
        if (n <= 1) {
            return n;
        }

        if (!memo.containsKey(n)){
            memo.put(n, climbStairsMapRec(n - 1, memo) + climbStairsMapRec(n - 2, memo));
        }
        return memo.get(n);
    }

    //3
    public static int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        int res1 = 1;
        int res2 = 1;
        for (int i = 2; i < n; i++) {
            int temp = res2;
            res2 = res1 + res2;
            res1 = temp;
        }

        return res1 + res2;
    }
}
