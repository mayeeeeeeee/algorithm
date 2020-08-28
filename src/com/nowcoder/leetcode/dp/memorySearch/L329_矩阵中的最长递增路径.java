package com.nowcoder.leetcode.dp.memorySearch;

/**
 * Created by wangzhiwen on 2020/2/3.
 */
public class L329_矩阵中的最长递增路径 {
    int rows, cols;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = dfs(i, j, matrix, dp);
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        int res = 1;
        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i, y = dy[k] + j;
            if (x >= 0 && x < rows && x >= 0 && y < cols && matrix[i][j] > matrix[x][y]) {
                 res = Math.max(res, dfs(x, y, matrix, dp) + 1);
            }
        }
        return res;
    }
}
