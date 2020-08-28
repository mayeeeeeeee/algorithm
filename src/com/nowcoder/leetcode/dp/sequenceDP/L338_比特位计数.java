package com.nowcoder.leetcode.dp.sequenceDP;

/**
 * Created by wangzhiwen on 2020/2/9.
 */
public class L338_比特位计数 {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1];

        }
        return dp;
    }
}
