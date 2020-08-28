package com.nowcoder.leetcode.dp.sequenceDP;

/**
 * Created by wangzhiwen on 2020/2/4.
 *
 */
/*
state      : f(i, j)表示从i到j合并的最低成本
function   : f(i, j) = min(f(i, k) + f(k + 1, j),sum(i, j))
initialize : f(i, i) = s(i, j)
answer     : f(0, n)
*/
public class L1000_合并石子的最低成本 {
    //当k=2时,k = n 时日后再研究吧
    public int mergeStones(int[] stones, int K) {
        int[][] sum = new int[stones.length][stones.length];
        sum(stones, sum);
        int[][] dp = new int[stones.length][stones.length];
        for (int i = stones.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < stones.length; j++) {
                if (j - i == 1) {
                    dp[i][j] = sum[i][j];
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j] + sum[i][j], dp[i][j]);
                }
                System.out.println(i + " " + j + " " + dp[i][j]);
            }
        }
        return dp[0][stones.length - 1];
    }
    public void sum(int[]stones, int sum[][]) {
        for (int i = 0; i < stones.length; i++) {
            for (int j = i; j < stones.length; j++) {
                if (i == j) {
                    sum[i][j] = stones[i];
                    continue;
                }
                sum[i][j] = sum[i][j - 1] + stones[j];
            }
        }
    }

    public int mergeStones1(int[] stones, int K) {
        int n = stones.length;
        if ((n-1) % (K-1) != 0) return -1;
        int[][] dp = new int[n][n];
        int[] sum = new int[n+1];
        for (int i = 0 ; i < n ; i++){
            dp[i][i] = 0;
            sum[i+1] += sum[i]+stones[i];
        }
        for (int j = 1 ; j < n ; j++){
            for (int i = j-1 ; i >= 0 ; i--){
                dp[i][j] = dp[i+1][j];
                for (int cut = i+K-1 ; cut < j ; cut += K-1){
                    dp[i][j] = Math.min(dp[i][j], dp[i][cut]+dp[cut+1][j]);
                }
                if ((j-i) % (K-1) == 0) {
                    dp[i][j] += sum[j+1]-sum[i];
                }
            }
        }
        return dp[0][n-1];
    }
}
