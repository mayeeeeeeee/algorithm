package com.nowcoder.leetcode.dp.sequenceDP;

/**
 * Created by wangzhiwen on 2020/2/8.
 * lintcode 515
 */
/*
state      : f(i, j) 前i个房子的最小话费，并且第i个房子为j色
function   :
initialize :
answer     :
*/
public class L256_粉刷房子 {
    public int minCost(int[][] costs) {
        // write your code here
        int m = costs.length;
        int[][] dp = new int[m + 1][3];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + costs[i - 1][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[m][i]);
        }
        return min;
    }
}
