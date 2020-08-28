package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/24.
 */
public class L213_打家劫舍II {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        return Math.max(f(nums, 0, nums.length - 2), f(nums, 1, nums.length - 1));
    }
    int f(int[] nums, int l, int r) {
        int[] dp = new int[r - l + 2];
        for (int i = 1; i <= r - l + 1; i++) {
            if (i >= 2) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1 + l]);
            }
            else {
                dp[i] = nums[i - 1 + l];
            }
        }
        return dp[r - l + 1];
    }
}
