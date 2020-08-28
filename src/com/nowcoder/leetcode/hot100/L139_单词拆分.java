package com.nowcoder.leetcode.hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wangzhiwen on 2020/2/19.
 */
public class L139_单词拆分 {
    //回溯 + 记忆化搜索
    //dfs的结果是什么，记忆化就存什么
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return false;
        }
        return dfs(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    private boolean dfs(String s, Set<String> set, int index, Boolean[] dp) {
        if (index == s.length()) {
            return true;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        for (int i = index; i < s.length(); i++) {
            if (set.contains(s.substring(index, i + 1)) && dfs(s, set, i + 1, dp)) {
                 return dp[index] = true;
            }
        }
        return dp[index] = false;
    }
}
