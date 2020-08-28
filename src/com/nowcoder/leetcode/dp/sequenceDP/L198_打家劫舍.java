package com.nowcoder.leetcode.dp.sequenceDP;

/**
 * Created by wangzhiwen on 2020/1/30.
 */
//state      : f(i)前i家最多偷多少钱
//function   : f(i) = max(f(i - 2) + nums(i), f(i - 1)) nums(i)表示第i个数
//initialize : f(0) = 0  f(1) = nums(1)
//answer     : f(n)
    /*序列型dp初始化2个及以上时在内部，一个在外部*/
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
