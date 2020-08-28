package com.nowcoder.leetcode.dp.matrixDP;

/**
 * Created by wangzhiwen on 2020/1/29.
 * f[i][j]:从起点走到i，j的最短路径和
 */
//state      : f(i, j)从(0, 0)到(i, j)最小路径和
//function   : f(i, j) = min(f(i - 1, j), f(i, j - 1)) + a(i, j)
//initialize : f(0, 0) = a[0][0] f(i, 0) = f(i - 1, 0) + a(i, j) f(j, 0) = f(j - 1, 0) + a(i, j)
//answer     : f(rows - 1, cols - 1)
public class L64_最小路径和 {
    public int minPathSum(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) {
            return 0;
        }
        int rows = nums.length, cols = nums[0].length;
        int dp[][] = new int[rows][cols]; //足以表示所有情况
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //initialize 此题在内部初始化比较方便
                if (i == 0 && j == 0) {
                    dp[i][j] = nums[i][j];
                }
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + nums[i][j];
                }
                else if (j == 0) {
                    dp[i][j] = dp[i][j - 1] + nums[i][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + nums[i][j];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
    //滚动数组优化
    public int minPathSum1(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        int dp[][] = new int[1][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(i==0 && j==0) {
                    dp[0][j] = grid[i][j];
                }
                else if(i == 0) {
                    dp[0][j] = dp[0][j-1] + grid[i][j];
                }
                else if(j == 0) {
                    dp[0][j] = dp[0][j] + grid[i][j];
                }
                else {
                    dp[0][j] = Math.min(dp[0][j], dp[0][j-1]) + grid[i][j];
                }
            }
        }
        return dp[0][cols-1];
    }
}
