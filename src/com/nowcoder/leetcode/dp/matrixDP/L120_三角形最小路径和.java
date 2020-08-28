package com.nowcoder.leetcode.dp.matrixDP;

import java.util.*;

/**
 * Created by wangzhiwen on 2020/1/27.
 */
//state      : f(i, j)表示(i, j)自顶向下到(0, 0)路径和
//function   : f(i, j) = max(f(i + 1, j), f(i + 1, j + 1)) + nums(i, j)
//initialize : f(n - 1, j)
//answer     : f(0, 0)
public class L120_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() ==0) {
            return 0;
        }
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == triangle.size() - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                    continue;
                }
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
