package leetcode.roadmap._9_bitoperations;

public class _6_477_TotalHammingDistance {

    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance(nums));
    }

    //For each bit position 1-32 in a 32-bit integer, we count the number of integers in the array which have that bit set.
    //Then, if there are n integers in the array and k of them have a particular bit set and (n-k) do not,
    //then that bit contributes k*(n-k) hamming distance to the total.
    public static int totalHammingDistance_2(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int num : nums) {
                bitCount += (num >> i) & 1;
            }
            total += bitCount * (n - bitCount);
        }
        return total;
    }

    //n^2
    public static int totalHammingDistance(int[] nums) {
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int cur = nums[i];
                int next = nums[j];

                for (int k = 0; k < 32; k++) {
                    int currBit = cur & 1;
                    int nextBit = next & 1;

                    if (currBit != nextBit) {
                        cnt++;
                    }

                    cur >>= 1;
                    next >>= 1;
                }

            }

        }

        return cnt;
    }
}
