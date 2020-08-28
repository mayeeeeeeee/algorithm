package com.nowcoder.leetcode.dp.sequenceDP;

/**
 * Created by wangzhiwen on 2020/2/4.
 */
/*
state      : 先手f(i,j)从i到j最多拿多少块石头
function   : f(i, j) = max(min(f(i + 2, j), f(i + 1, j - 1)) + s[i], min(f(i + 1, j - 1), f(i, j - 2)) + s[j])
initialize :
answer     : f(0, n)
*/
public class L877_石子问题 {
    public boolean stoneGame(int[] piles) {
        if (piles == null || piles.length == 0) {
            return false;
        }
        int[][] dp = new int[piles.length][piles.length];
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
        }
        for (int i = piles.length - 1; i >= 0; i++) {
            for (int j = i; j < piles.length; j++) {
                if (j - i == 1) {
                    dp[i][j] = piles[i];
                    continue;
                }
                if (j - i == 2) {
                    dp[i][j] = Math.max(piles[i], piles[j]);
                    continue;
                }
                dp[i][j] = Math.max(Math.min(dp[i + 2][j], dp[i + 1][j - 1]) + piles[i], Math.min(dp[i + 1][j - 1], dp[i][j - 2]) + piles[j]);
            }
        }
        return dp[0][piles.length] * 2 > sum;
    }
}
