package com.nowcoder.leetcode.dp.matrixDP;

/**
 * Created by wangzhiwen on 2020/1/27.
 * f(i,j)=f(i-1,j)+f(i,j-1);
 */
//state      : f(i, j)从(0, 0)到(i, j)路径条数
//function   : f(i, j) = f(i, j - 1) + f(i - 1, j)
//initialize : f(i, j) = 0(nums[i][j] == 1)  f(0, 0) = 1  f(0, j) = f(0, j - 1)  f(i, 0) = f(i - 1, 0)
//answer     : f(m - 1, n - 1)
public class L63_不同路径II {
    public int uniquePathsWithObstacles(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) {
            return 0;
        }
        int rows = nums.length, cols = nums[0].length;
        int dp[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (nums[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
