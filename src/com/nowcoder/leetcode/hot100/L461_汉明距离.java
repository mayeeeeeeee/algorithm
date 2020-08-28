package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/4.
 */
public class L461_汉明距离 {
    public int hammingDistance(int x, int y) {
        x = x ^ y;
        y = 0;
        while (x != 0) {
            y += x & 1;
            x = x >> 1;
        }
        return y;
    }
}
