package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/3/3.
 */
public class L309_最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];//0:买 1:卖 2:无
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        dp[0][0] = 0 - prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][2] - prices[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + prices[i];
            dp[i][2] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }
}
