package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/13.
 *
 */
public class L55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j <= nums[j] && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
