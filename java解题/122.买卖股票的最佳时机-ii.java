/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */
class Solution {
    public int maxProfit(int[] prices) {
        int j = 1, i = 0, sum = 0;
        for (; j <= prices.length - 1; i++, j++) {
            if (prices[i] < prices[j]) {
                sum += (prices[j] - prices[i]);
            }
        }
        return sum;
    }
}
