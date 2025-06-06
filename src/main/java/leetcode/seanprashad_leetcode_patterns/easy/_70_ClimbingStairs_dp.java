package leetcode.seanprashad_leetcode_patterns.easy;

public class _70_ClimbingStairs_dp {

    public static void main(String[] args) {

    }

    //dp
    public int climbStairs(int n) {
        if (n <= 3) return n;

        int prev1 = 3;
        int prev2 = 2;
        int cur = 0;

        for (int i = 3; i < n; i++) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return cur;
    }
}
