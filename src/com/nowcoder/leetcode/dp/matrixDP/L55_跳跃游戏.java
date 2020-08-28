package com.nowcoder.leetcode.dp.matrixDP;

/**
 * Created by wangzhiwen on 2020/1/29.
 * f[i]：能否到达第i个位置
 */
//state      : f(i)代表能否从起点跳到第i个位置
//function   : f(i) = OR (nums[i] >= i - k && f(k))
//initialize : f(0) = true
//answer     : f(n - 1)
public class L55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }
        boolean dp[] = new boolean[nums.length];
        dp[0] = true;
        //i从1(第二个)到n-1(第n个) j=i-1从0到n-2
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if(i - j <= nums[j] && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
}
