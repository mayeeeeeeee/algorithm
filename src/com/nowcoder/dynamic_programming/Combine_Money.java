package com.nowcoder.dynamic_programming;

import java.util.*;

/**
 * Created by wangzhiwen on 2019/4/10.
 * https://blog.csdn.net/weixin_40255793/article/details/79634651
 * 钱币组合问题
 * 输入：1,2,5 100
 * 输出：541
 * 输出需空格
 * 多行需回车
 */
public class Combine_Money {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//
//        }
        System.out.println(numOfCombine(100));

    }
    public static long numOfCombine(int N) {
        if (N < 0) throw new IllegalArgumentException();
        if (N == 0) return 0;

        int[] p = {1,2,5};
        long[] a = new long[N + 1];
        a[0]=0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == p[i]) {
                    a[j] += 1;
                }
                else if(j>p[i]){
                    a[j] += a[j - p[i]];
                }
            }
        }
        return a[N];
    }
}
