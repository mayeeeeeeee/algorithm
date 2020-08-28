package com.nowcoder.leetcode.dp.twoSequencesDP;

/**
 * Created by wangzhiwen on 2020/2/1.
 * f(i, j) = f(i - 1, j - 1) + 1 s1[i - 1] == s2[j - 1]
 * f(i, j) = Max(f(i, j - 1), f(i - 1, j))
 */
//state      : f(i, j)表示s1前i个和s2前j个最长公共子序列
//function   : f(i, j) = f(i - 1, j - 1) + 1             s1[i - 1] == s2[j - 1]
//             f(i, j) = Max(f(i, j - 1), f(i - 1, j))   other
//answer     : dp[m][n]
public class L1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    //滚动数组优化
    public int longestCommonSubsequence1(String text1, String text2) {
        int dp[][] = new int[2][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i & 1][j] = dp[i - 1 & 1][j - 1] + 1;
                } else {
                    //不能只开一个原因是等号一遍存在2个(右同时存在i-1和i)
                    dp[i & 1][j] = Math.max(dp[i - 1 & 1][j], dp[i & 1][j - 1]);
                }
            }
        }
        return dp[text1.length() & 1][text2.length()];
    }
}
