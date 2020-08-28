package com.nowcoder.double_pointer;

/**
 * Created by wangzhiwen on 2019/5/29.
 * Leetcode 680
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 输入: "abca"
 * 输出: True
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
