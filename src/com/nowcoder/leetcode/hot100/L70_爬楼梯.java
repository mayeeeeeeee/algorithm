package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/1/28.
 * f(n)=f(n-1)+f(n-2)
 */
public class L70_爬楼梯 {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <n+1 ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //滚动数组
    public int climbStairs1(int n) {
        if(n<2){
            return n;
        }
        int dp[]=new int[2];
        dp[1&1]=1;
        dp[2&1]=2;
        for (int i = 3; i <n+1 ; i++) {
            dp[i&1]=dp[i-1&1]+dp[i-2&1];
        }
        return dp[n&1];
    }
}
