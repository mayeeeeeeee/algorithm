package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/1/30.
 * f(i):前i家最多能偷多少钱
 */
public class L198_打家劫舍 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length + 1];
        for (int i = 1; i <=nums.length ; i++) {
            if(i >= 2) {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            }
            else {
                dp[i] = nums[i - 1];
            }
        }
        return dp[nums.length];
    }
}
