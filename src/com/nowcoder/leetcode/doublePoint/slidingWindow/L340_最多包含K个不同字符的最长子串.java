package com.nowcoder.leetcode.doublePoint.slidingWindow;

/**
 * Created by wangzhiwen on 2020/2/6.
 * Leetcode需要会员 lintcode386
 *先处理，后判断
 */
public class L340_最多包含K个不同字符的最长子串 {
    //九章模版
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int j = 0, ans = 0, now = 0, max = 0;
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && now <= k) {//判断
                max = Math.max(max, j - i);
                map[s.charAt(j)]++;
                if (map[s.charAt(j)] == 1) {//处理，下次循环判断当前处理后的结果
                    now++;
                }
                j++;
            }

            if (now > k) {
                map[s.charAt(i)]--;
                if (map[s.charAt(i)] == 0) {//处理
                    now--;
                }
            }

            else {
                return Math.max(max, j - i);
            }

        }
        return max == 0 ? s.length() : max;
    }
    //自己的模版
    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
        int[] map = new int[256];
        int l = 0, r = 0, now = 0, max = 0;
        while (r < s.length()) {
            map[s.charAt(r)]++;
            if (map[s.charAt(r)] == 1) {
                now++;
            }
            r++;
            while (now > k) {
                map[s.charAt(l)]--;
                if (map[s.charAt(l)] == 0) {
                    now--;
                }
            }
            max = Math.max(max, r - l);
        }
        return max;
    }
}

