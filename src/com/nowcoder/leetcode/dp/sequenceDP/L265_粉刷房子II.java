package com.nowcoder.leetcode.dp.sequenceDP;

/**
 * Created by wangzhiwen on 2020/2/9.
 * lintcode 516
 */
/*
state      : f(i, j)第i个房子用第j个颜色最小花费
function   : f(i, j) = min(f(i - 1, k(k != j))) + costs(j)
initialize :
answer     : min(f(n, k))
*/
public class L265_粉刷房子II {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }
        int numHouse = costs.length, numColor = costs[0].length, min = Integer.MAX_VALUE;
        int[][] dp = new int[numHouse + 1][numColor];
        for (int i = 1; i <= numHouse; i++) {
            int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE, firstId = 0, secondId = 0;
            /*一次遍历求出最小值，次小值*/
            for (int j = 0; j < numColor; j++) {
                if (dp[i - 1][j] < firstMin) {
                    secondMin = firstMin;
                    firstMin = dp[i - 1][j];
                    secondId = firstId;
                    firstId = j;
                }
                else if (dp[i - 1][j] < secondMin) {
                    secondMin = dp[i - 1][j];
                    secondId = j;
                }
            }
            for (int j = 0; j < numColor; j++) {
                if (j == firstId) {
                    dp[i][j] = dp[i - 1][secondId] + costs[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][firstId] + costs[i - 1][j];
                }
            }
        }
        for (int i = 0; i < dp[numHouse].length; i++) {
            min = Math.min(dp[numHouse][i], min);
        }
        return min;
    }
}
