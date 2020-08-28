package com.nowcoder.leetcode.dp.sequenceDP;

/**
 * Created by wangzhiwen on 2020/1/31.
 * f(i,j):表示从i打印到j最少几种
 * f(i, j) = f(i + 1, j) + 1                 s[i] 单独打印
 * f(i, j) = f(i + 1, k) + f(K + 1, j)       s[i] 和后面一起打印
 * f(i, j) = f(i + 1, j)
 */
public class L664_奇怪的打印机 {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int dp[][] = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {//for 从头开始避免外面特判
            for (int j = i; j < s.length() ; j++) {
                    dp[i][j] = dp[i + 1][j] + 1;
                    for (int k = i + 1; k < j; k++) {
                        if (s.charAt(i) == s.charAt(k)) {
                            dp[i][j] = Math.min(dp[i][j], dp[i + 1][k] + dp[k + 1][j]);
                        }
                    }
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j]);
                    }

            }
        }
        return dp[0][s.length() - 1];
    }
    //yxc 通过多开一个数组来消除一些特判条件
    public int strangePrinter1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int dp[][] = new int[s.length() + 1][s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {//for 从头开始避免外面特判
            for (int j = i; j < s.length() ; j++) {
                dp[i][j] = dp[i + 1][j] + 1;
                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(i) == s.charAt(k)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
