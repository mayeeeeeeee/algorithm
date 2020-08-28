package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/3/4.
 */
public class L322_零钱兑换 {
    public int coinChange(int[] A, int M) {
        int[] f = new int[M + 1];
        int n = A.length;
        f[0] = 0;
        int i, j;
        for (i = 1; i <= M; ++i) {
            f[i] = -1;
            for (j = 0; j < n; ++j) {
                if (i >= A[j] && f[i - A[j]] != -1) {
                    if (f[i] == -1 || f[i - A[j]] + 1 < f[i]) {
                        f[i] = f[i - A[j]] + 1;
                    }
                }
            }
        }

        return f[M];
    }
}
