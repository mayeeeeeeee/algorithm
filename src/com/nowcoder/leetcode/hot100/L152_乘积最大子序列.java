package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/21.
 */
public class L152_乘积最大子序列 {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int max = nums[0];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] * nums[i], Math.max(dp[i - 1][1] * nums[i], nums[i]));
            dp[i][1] = Math.min(dp[i - 1][0] * nums[i], Math.min(dp[i - 1][1] * nums[i], nums[i]));
            max = Math.max(dp[i][0], max);
        }
        return max;
    }
}
