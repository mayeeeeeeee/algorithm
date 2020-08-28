package com.nowcoder.leetcode.dp.twoSequencesDP;

/**
 * Created by wangzhiwen on 2020/2/1.
 * f(i, j)表示s前i中包含t前j的序列的个数
 * f(i, j) = f(i - 1, j)                                s[i] != t[j]
 * f(i, j) = f(i - 1, j - 1) + f(i - 1, j)              s[i] == t[j]
 */
/*
state      : f(i, j)表示s前i中包含t前j的序列的个数
function   : f(i, j) = f(i - 1, j)                    s[i] != t[j]
             f(i, j) = f(i - 1, j - 1) + f(i - 1, j)  other
initialize : f(0,0) = 1  f(i, 0) = 1  f(0, j) = 0
answer     : f(m,n)
*/
public class L115_不同的子序列 {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];

                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
