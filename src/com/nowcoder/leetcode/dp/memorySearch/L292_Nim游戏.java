package com.nowcoder.leetcode.dp.memorySearch;

/**
 * Created by wangzhiwen on 2020/2/4.
 * coins in a line
 */
/*
state      : f(i)i块石头先手拿能否获胜
function   : f(i) = (f(i - 2) && f(i - 3) && f(i - 4)) || (f(i - 3) && f(i - 4) && f(i - 5)) || (f(i - 4) && f(i - 5) && f(i - 6)))
initialize : f(0) ~ f(6)
answer     : f(n)
*/
public class L292_Nim游戏 {
    //TLE
    public boolean canWinNim(int n) {
        int[] dp = new int[n + 1];
        return MemorySearch(dp, n);
    }

    private boolean MemorySearch(int[] dp, int n) {
        if (dp[n] != 0) {
            return dp[n] == 1;
        }
        if (n < 1) {
            dp[n] = 2;
        }else if (n == 1) {
            dp[n] = 1;
        }else if (n == 2) {
            dp[n] = 1;
        }else if (n == 3) {
            dp[n] = 1;
        }else if (n == 4) {
            dp[n] = 2;
        }else if (n == 5) {
            dp[n] = 1;
        }else if (n == 6) {
            dp[n] = 1;
        }else {
            dp[n] = ((MemorySearch(dp, n - 2) && MemorySearch(dp, n - 3) && MemorySearch(dp, n - 4)) || (MemorySearch(dp, n - 3) && MemorySearch(dp, n - 4) && MemorySearch(dp, n - 5)) || (MemorySearch(dp, n - 4) && MemorySearch(dp, n - 5) && MemorySearch(dp, n - 6))) ? 1 : 2;
        }
        return dp[n] == 1;
    }



/*
follow up：有n个不同价值的硬币排成一条线。两个参赛者轮流从左边依次拿走1或2个硬币，直到没有硬币为止。计算两个人分别拿到的硬币总价值，价值高的人获胜。
state      : f(i)i块石头先手拿能最多
function   : f(i) = max(min(f(i-2), f(i-3))+coin[n-i], (min(f(i-3), f(i-4)+coin[n-i]+coin[n-i+1] ))
initialize : f(0) ~ f(3)
answer     : dp[n] > sum/2
*/
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        int []dp = new int[n + 1];
        boolean []flag =new boolean[n + 1];
        int []sum = new int[n+1];
        int allsum = values[n-1];
        sum[n-1] = values[n-1];
        for(int i = n-2; i >= 0; i--) {
            sum[i] += sum[i+1] + values[i];
            allsum += values[i];
        }
        return allsum/2 < MemorySearch1(0, n, dp, flag, values, sum);
    }

    int MemorySearch1(int i, int n, int []dp, boolean []flag, int []values, int []sum) {
        if(flag[i])
            return dp[i];
        flag[i] = true;
        if(i == n)  {
            dp[n] = 0;
        } else if(i == n-1) {
            dp[i] = values[i];
        } else if(i == n-2) {
            dp[i] = values[i] + values[i + 1];
        } else {
            dp[i] = sum[i] -
                    Math.min(MemorySearch1(i+1, n, dp, flag, values, sum) , MemorySearch1(i+2, n, dp, flag, values, sum));
        }
        return dp[i];
    }








}
