package com.nowcoder.leetcode.dfsSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangzhiwen on 2020/1/31.
 */
public class L131_分割回文串 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        dfs(s, res, new ArrayList<String>(), 0);
        return res;
    }

    private void dfs(String s, List<List<String>> res, ArrayList<String> cur, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (isPalindrome(substring)) {
                cur.add(substring);
                dfs(s, res, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
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
