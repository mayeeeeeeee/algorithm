package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/6.
 */
public class L3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int j = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)] == 0) {
                ans = Math.max(ans, j - i + 1);
                map[s.charAt(j)]++;
                j++;
            }
            if(j < s.length()) {
                map[s.charAt(i)]--;
            }
        }
        return ans;
    }
}
