package com.nowcoder.leetcode.dp.memorySearch;

/**
 * Created by wangzhiwen on 2020/2/4.
 */
/*
state      : f(i, j) 从i到j先手取最大
function   : f(i, j) = max(min(f(i + 2, j), f(i + 1, j - 1) + s(i), min(f(i + 1, j - 1), f(i, j - 2)) + s(j))
initialize : f(i, i) f(i, i + 1)
answer     : f(0, n)
*/
public class L486_预测赢家 {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        long[][] dp = new long[nums.length][nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = nums.length - 1; i >= 0 ; i--) {
            for (int j = i; j < nums.length; j++) {
                if(j - i == 0) {
                    dp[i][j] = nums[i];
                    continue;
                }
                if(j - i == 1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);
                    continue;
                }
                dp[i][j] = Math.max(Math.min(dp[i + 2][j], dp[i + 1][j - 1]) + nums[i], Math.min(dp[i + 1][j - 1], dp[i][j - 2]) + nums[j]);
            }
        }
        return dp[0][nums.length - 1] * 2 >= sum;
    }
}
