package com.nowcoder.leetcode.dp.sequenceDP;

/**
 * Created by wangzhiwen on 2020/2/4.
 */
/*
state      : f(i, j)从i到j获得最大价值
function   : f(i, j) = max(f(i, k) + f(k + 1, j) + s(k) * s(i - 1) * s(j + 1))
initialize :
answer     : f(0, n)
*/
public class L312_戳气球 {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        int[] copy = new int[nums.length + 1];
        for (int i = 1; i < copy.length - 1; i++) {
            copy[i] = nums[i - 1];
        }
        copy[0] = 1;
        copy[copy.length - 1] = 1;
        for (int i = nums.length - 1; i <= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j] + copy[k + 1] * copy[i] * copy[j + 2]);
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}
