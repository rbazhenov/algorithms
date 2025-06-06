package leetcode.seanprashad_leetcode_patterns.easy;

public class _121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int target = prices[0];
        for (Integer price : prices) {
            if (price < target) {
                target = price;
                continue;
            }

            profit = Math.max(profit, price - target);
        }

        return profit;
    }
}
