package com.nowcoder.leetcode.dp.matrixDP;

/**
 * Created by wangzhiwen on 2020/1/27.
 * 状态定义为一个点的性质，即为matrixDP
 */
//state      : f(i)以sum[i]结尾的最大子序列和
//function   : f(i) = max(f(i - 1) + nums[i], nums[i])
//initialize : f(0) = nums[0]
//answer     : max(f(i))
public class L53_最大子序和 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; //初始化 + 只存在一个特判
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {//至少存在2个
            dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
