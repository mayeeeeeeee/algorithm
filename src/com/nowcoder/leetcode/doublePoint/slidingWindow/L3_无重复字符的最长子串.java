package com.nowcoder.leetcode.doublePoint.slidingWindow;

/**
 * Created by wangzhiwen on 2020/2/5.
 */
public class L3_无重复字符的最长子串 {
    //使用ascll码判断
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, ans = 0;
        int[] map = new int[256];
        while (r < s.length()) {
            map[s.charAt(r++)]++;
            while (map[s.charAt(r - 1)] > 1) {//出现重复的情况
                map[s.charAt(l++)]--;
            }
            ans = Math.max(ans, r - l);//所有不重复的情况
        }
        return ans;
    }
}
