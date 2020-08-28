package com.nowcoder.leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangzhiwen on 2020/3/1.
 */
public class L279_完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        // System.out.println(dp[n]);
        return dp[n];
    }
}
