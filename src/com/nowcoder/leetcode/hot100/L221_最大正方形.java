package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/26.
 */
public class L221_最大正方形 {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length, max = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    }
                    else if (i == 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                    else if (j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    max = Math.max(max, dp[i][j] * dp[i][j]);
                }
            }
        }
        return max;
    }
}
