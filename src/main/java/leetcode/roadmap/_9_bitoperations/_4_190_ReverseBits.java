package leetcode.roadmap._9_bitoperations;

public class _4_190_ReverseBits {

    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

    public static int reverseBitsBest(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++)
        {
            result = result << 1;
            result = result | (n & 1);
            n = n >>> 1;
        }

        return result;
    }


    public static int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        int biLen = binary.length();
        StringBuilder reversed = new StringBuilder(binary).reverse();
        reversed.append("0".repeat(32 - biLen));


        return (int) Long.parseLong(reversed.toString(), 2);
    }
}
