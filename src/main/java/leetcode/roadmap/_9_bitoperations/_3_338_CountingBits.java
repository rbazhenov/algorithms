package leetcode.roadmap._9_bitoperations;

import java.util.Arrays;

public class _3_338_CountingBits {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(Arrays.toString(countBits(n)));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.println("i = " + i + ". Binary i = " + Integer.toBinaryString(i));
            System.out.println("i >> 1 = " + Integer.toBinaryString(i >> 1));
            System.out.println("(i & 1) = " + Integer.toBinaryString(i & 1));
            ans[i] = ans[i >> 1] + (i & 1);
            System.out.println("Result i = " + Integer.toBinaryString(ans[i]));
            System.out.println();
        }
        return ans;
    }
}
