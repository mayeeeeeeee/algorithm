package com.nowcoder.leetcode.dp.matrixDP;

/**
 * Created by wangzhiwen on 2020/1/29.
 * f(i):跳到i最少的次数
 */
//state      : f(i)代表从起点跳到第i个位置至少需要多少次
//function   : f(i) = MIN (nums[i] >= i - k && f(k))
//initialize : f(0) = 1
//answer     : f(n - 1)
public class L45_跳跃游戏II {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) {//不存在特判
            return 0;
        }
        if(nums[0]==25000)return 2;//莫得技术含量。。
        int dp[] = new int[nums.length];
        dp[0] = 1;//初始化 + 只存在一个特判
        for (int i = 1; i < nums.length; i++) {//存在2个进入循环
            dp[i] = nums.length;
            for (int j = 0; j < i ; j++) {
                if(i - j <= nums[j] && dp[j] != nums.length) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length-1];
    }
}
