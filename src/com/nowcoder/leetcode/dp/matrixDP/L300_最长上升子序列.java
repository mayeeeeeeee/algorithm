package com.nowcoder.leetcode.dp.matrixDP;

/**
 * Created by wangzhiwen on 2020/1/30.
 * f(i):以第i个数结尾最长递增子序列
 * 求第i的dp最好从0开始
 * 前i的最好从1开始
 */
public class L300_最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
