package com.nowcoder.leetcode.dp.sequenceDP;

/**
 * Created by wangzhiwen on 2020/2/9.
 */
/*
state      : f(i, j)表示前i天第j种状态的最大获利
function   :
initialize :
answer     :
*/
/*      dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
        dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
        dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
        dp[i][1][1] = max(dp[i-1][1][1], -prices[i])                                    */

public class L123_买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }
}
