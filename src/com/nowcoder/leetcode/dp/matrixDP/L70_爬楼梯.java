package com.nowcoder.leetcode.dp.matrixDP;

/**
 * Created by wangzhiwen on 2020/1/29.
 */
//state      : f(i) 跳到第i个位置的方案总数
//function   : f[i] = f[i-1] + f[i-2]
//initialize : f(0) = 1 f(1) = 2
//answer     : f(n - 1)
public class L70_爬楼梯 {
    //在for内初始化代码
    public int climbStairs(int n) {
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            //能在for里面初始化尽量在里面初始化边界条件
            if (i < 2) {
                dp[i] = i + 1;
            }
            else  {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n - 1];
    }

    //在for外初始化代码
    public int climbStairs1(int n) {
        int dp[] = new int[n];
        //在外初始化dp[0],dp[1],需在外特判是否越界
        if(n < 2) {//为保障dp[0],dp[1]不越界
            return n - 1;
        }
        dp[0] = 1;//出现数组的地方就有越界问题，所以能统一尽量统一
        dp[1] = 2;
        for (int i = 2; i < n; i++) {//i = 2保障dp[i - 1],dp[i - 2]不越界
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n - 1];
    }
}
