package com.nowcoder.dynamic_programming;

/**
 * Created by wangzhiwen on 2019/5/22.
 * 统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动。
 * in m,n(行列数)
 * out 路径数
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3,2));
    }
    public int uniquePaths(int m, int n) {
        int dp[]=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0||i==0){
                    dp[j]=1;
                }
                else {
                    dp[j]=dp[j-1]+dp[j];
                }
            }
        }
        return dp[n-1];
    }
}
