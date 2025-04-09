package leetcode.easy;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class _121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
//        int[] prices = {2,1,2,1,0,0,1};
        int[] prices = {2,7,1,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int target = prices[0];
        for (int i = 1; i < prices.length; i++) {
            target = Math.min(target, prices[i]);
            profit = Math.max(profit, prices[i] - target);
        }

        return profit;
    }

    public static int maxProfit2(int[] prices) {
        int profit = 0;
        int target = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < target) {
                target = prices[i];
                continue;
            }
            profit = Math.max(profit, prices[i] - target);
        }

        return profit;
    }
}
