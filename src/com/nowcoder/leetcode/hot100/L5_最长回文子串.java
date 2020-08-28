package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/6.
 */
public class L5_最长回文子串 {
    //中心扩展法
    public String longestPalindrome(String s) {
        String res = "";
        int i = 0;
        while (i < s.length()){
            int j = i, k = i;
            for (; j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k); j--, k++) ;
            if (k - j - 1 > res.length()) {
                res = s.substring(j + 1, k);
            }
            j = i;
            k = i + 1;
            for (; j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k); j--, k++) ;
            if (k - j - 1 > res.length()) {
                res = s.substring(j + 1, k);
            }
            i++;
        }
        return res;
    }
    //动态规划法
}
