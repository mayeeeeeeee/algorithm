package com.nowcoder.leetcode.dp.sequenceDP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wangzhiwen on 2020/2/2.
 * 对于字符串拆分问题如139单词拆分、132分割回文串，解法如下
 */
//state      : f(i)前i个字符能否拆分
//function   : f(i) = f(i) || f(k) (check(s(k + 1, i) == true)
//initialize : f(0) = true f(i) = false
//answer     : f(n)
public class L139_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        words.addAll(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = words.contains(s.substring(0,1));
        for (int i = 1; i <= n ; i++) {
            dp[i] = false;
            for (int j = 1; j <= i ; j++) {
                if (words.contains(s.substring(j - 1, i))) {
                    dp[i] = dp[i] || dp[j - 1];
                }
            }
        }
        return dp[n];
    }
}
