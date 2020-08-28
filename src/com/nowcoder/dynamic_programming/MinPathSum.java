package com.nowcoder.dynamic_programming;

/**
 * Created by wangzhiwen on 2019/5/22.
 * 求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
 * 例：[[1,3,1],
 *    [1,5,1],
 *    [4,2,1]] Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinPathSum {
    public static void main(String[] args) {
        int [][]grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new MinPathSum().minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        if (grid==null||grid.length==0)
            return 0;
        int rows=grid.length,cols=grid[0].length;
        int a[][]=new int[rows][cols];
        a[0][0]=grid[0][0];
        for(int i=1;i<rows;i++){
            a[i][0]=a[i-1][0]+grid[i][0];
        }
        if(cols==1){
            return a[rows-1][0];
        }
        for(int j=1;j<cols;j++){
            a[0][j]=a[0][j-1]+grid[0][j];
        }
        if(rows==1){
            return a[0][cols-1];
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                a[i][j]=Math.min(a[i-1][j],a[i][j-1])+grid[i][j];
            }
        }
        return a[rows-1][cols-1];
    }
    //优化  感觉有点小无敌
    public int minPathSum1(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = dp[j];        // 只能从上侧走到该位置
                } else if (i == 0) {
                    dp[j] = dp[j - 1];    // 只能从左侧走到该位置
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
    }

}
