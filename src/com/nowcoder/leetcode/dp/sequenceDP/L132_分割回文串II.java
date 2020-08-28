package com.nowcoder.leetcode.dp.sequenceDP;

/**
 * Created by wangzhiwen on 2020/1/31.
 */
//state      : f(i)前i个字符分割成回文串最少分割次数
//function   : f(i) = f(k) + 1 (isPalindrome(s(k + 1, i) == true)
//initialize : f(0) = -1
//answer     : f(n)
public class L132_分割回文串II {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n + 1];
        dp[0] = -1;//初始化(本身没啥意义，保证dp[1]计算正确)
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            //i从1到n，j=i-1，从0到i-1
            for (int j = i; j > 0; j--) {
                if (isPalindrome(s.substring(j - 1, i))) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n];
    }
    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
