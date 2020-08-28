package com.nowcoder.leetcode.dp.matrixDP;

/**
 * Created by wangzhiwen on 2020/1/29.
 */
//state      : f(i, j)从(0, 0)走到(i, j)路径数
//function   : f(i, j) = f(i, j - 1) + f(i - 1, j)
//initialize : f(0, i) = f(0, j) = 1
//answer     : f(m, n)
public class L62_不同路径 {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    //initialize
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
