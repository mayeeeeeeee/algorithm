package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/16.
 */
public class L96_不同的二叉搜索树 {
    public int numTrees(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

}
