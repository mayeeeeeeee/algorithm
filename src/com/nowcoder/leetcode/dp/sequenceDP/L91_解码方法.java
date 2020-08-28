package com.nowcoder.leetcode.dp.sequenceDP;

/**
 * Created by wangzhiwen on 2020/1/30.
 * f(i):前i个字符的解码总数
 * 初始化复杂时，可以从for内初始化
 */
public class L91_解码方法 {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int dp[] =new int[s.length() + 1];
        if (s.length() == 1 && s.charAt(0) == '0') {
            return 0;
        }
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= s.length() ; i++) {
            int cur = s.charAt(i - 1) - '0', pre = s.charAt(i - 2) - '0';
            if (cur == 0 && (pre == 0 || pre > 2)) {
                return 0;
            }
            if (cur == 0) {
                dp[i] = dp[i - 2];
            }
            else if (pre <= 2 && pre != 0 && cur <= 6) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    //yxc
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i >= 2) {
                int sum = s.charAt(i - 1) - '0' + (s.charAt(i - 2) - '0') * 10;
                if (sum >= 10 && sum <= 26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[s.length()];
    }
}
