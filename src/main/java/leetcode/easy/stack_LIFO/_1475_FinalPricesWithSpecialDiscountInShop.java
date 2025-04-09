package leetcode.easy.stack_LIFO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * You are given an integer array prices where prices[i] is the price of the ith item in a shop.
 * <p>
 * There is a special discount for items in the shop.
 * If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i].
 * Otherwise, you will not receive any discount at all.
 * <p>
 * Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
 */
public class _1475_FinalPricesWithSpecialDiscountInShop {

    public static void main(String[] args) {
//        int[] prices = {8, 4, 6, 2, 3};
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {10,1,1,6};
        int[] prices = {10, 2, 5, 2, 8};
//        System.out.println(Arrays.toString(finalPrices(prices)));
        System.out.println(Arrays.toString(stack(prices)));
    }

    //last in - first out
    public static int[] stack(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < stack.peek()) {
                stack.pop();
            }

            int discount = stack.isEmpty() ? 0 : stack.peek();
            stack.push(prices[i]);
            prices[i] -= discount;
        }

        return prices;
    }


    //my omg. it's too long
    public static int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {

            if (!map.isEmpty()) {
                Set<Integer> toRemove = new HashSet<>();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() >= prices[i]) {
                        result[entry.getKey()] = entry.getValue() - prices[i];
                        toRemove.add(entry.getKey());
                    }
                }
                toRemove.forEach(map::remove);
            }

            if (i == prices.length - 1) {
                result[i] = prices[i];
                map.forEach((k, v) -> result[k] = v);
                break;
            }

            if (prices[i] >= prices[i + 1]) {
                result[i] = prices[i] - prices[i + 1];
            } else {
                map.put(i, prices[i]);
            }
        }

        return result;
    }
}
