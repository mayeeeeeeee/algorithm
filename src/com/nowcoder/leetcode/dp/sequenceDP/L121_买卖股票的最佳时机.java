package com.nowcoder.leetcode.dp.sequenceDP;

/**
 * Created by wangzhiwen on 2020/2/9.
 *
 */
/*参考题解https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
 *   dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])*
 */
//状态机要研究一下
public class L121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];//0:持有 2:不持有
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int max = 0;
        dp[0][0] = 0 - prices[0];
        dp[1][0] = 0 - Math.min(prices[0], prices[1]);
        for (int i = 1; i < prices.length; i++) {
            if (i >= 2) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            }
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }
}
