package com.nowcoder.leetcode.dp.twoSequencesDP;

/**
 * Created by wangzhiwen on 2020/2/3.
 */
//state      : f(i, j)前j个硬币组成i最少用多少个
//function   : f(i, j) = min(f(i - s[j], j) + 1,f(i, j - 1))
//initialize :
//answer     : f(m, n)
public class L322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp= new int[amount + 1][coins.length + 1];
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j <= coins.length; j++) {
                if (j == 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if (coins[j - 1] == i) {
                    dp[i][j] = 1;
                } else if (coins[j - 1] < i) {
                    dp[i][j] = Math.min(dp[i - coins[j - 1]][j - 1] + 1, dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        if (dp[amount][coins.length] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount][coins.length];
    }
}
