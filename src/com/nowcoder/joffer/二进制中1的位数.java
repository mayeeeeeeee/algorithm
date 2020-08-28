package com.nowcoder.joffer;

/**
 * Created by wangzhiwen on 2019/10/6.
 */
public class 二进制中1的位数 {
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
}
