package com.nowcoder.leetcode.dp.twoSequencesDP;

import java.util.Arrays;

/**
 * Created by wangzhiwen on 2020/1/30.
 * 先不考虑初始化问题正常写边界。根据需求考虑初始化边界
 */
//state      : f(i, j)表示i块钱用前j个硬币凑方案总数
//function   : f(i, j) = f(i, j - 1) + f(i - s(j), j) i >= s(j) == true
//initialize : f(0, j) = 1
//answer     : f(m, n)
public class L518_零钱兑换II {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i <= amount; i++) {
            for (int j = 1; j <= coins.length; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i >= coins[j]) {
                    dp[i][j] = dp[i][j - 1] + dp[i - coins[j - 1]][j];
                }
                else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[amount][coins.length];
    }
}
