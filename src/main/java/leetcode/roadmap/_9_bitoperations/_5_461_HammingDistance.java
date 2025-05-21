package leetcode.roadmap._9_bitoperations;

public class _5_461_HammingDistance {

    public static void main(String[] args) {
        int x = 100;
        int y = 1;

        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        String big = Integer.toBinaryString(x);
        String small = Integer.toBinaryString(y);

        if (big.length() < small.length()) {
            String temp = big;
            big = small;
            small = temp;
        }

        int lenDif = big.length() - small.length();
        small = "0".repeat(lenDif) + small;

        if (big.length() != small.length()) {
            System.out.println("You are stupid");
        }

        int cnt = 0;
        for (int i = 0; i < big.length(); i++) {
            if (big.charAt(i) != small.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    public int hammingDistanceBest(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int currXBit = x & 1;
            int currYBit = y & 1;
            if (currXBit != currYBit) {
                count++;
            }
            x >>= 1;
            y >>= 1;
        }
        return count;
    }
}
