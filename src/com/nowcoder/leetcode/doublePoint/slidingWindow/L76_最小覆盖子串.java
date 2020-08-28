package com.nowcoder.leetcode.doublePoint.slidingWindow;

/**
 * Created by wangzhiwen on 2020/2/5.
 */
public class L76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        int[] maps = new int[256], mapt = new int[256];
        int count = 0, now = 0, l = 0, r = 0, first = -1, len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            mapt[t.charAt(i)]++;
            if (mapt[t.charAt(i)] == 1) {
                count++;
            }
        }
        while (r < s.length()) {
            maps[s.charAt(r)]++;
            if (maps[s.charAt(r)] == mapt[s.charAt(r)]) {
                now++;
            }
            r++;
            while (now >= count) {
                maps[s.charAt(l)]--;
                if (maps[s.charAt(l)] == mapt[s.charAt(l)] - 1) {
                    now--;
                }
                if (r - l < len) {
                    first = l;
                    len = r - l;
                }
                l++;
            }
        }
        return first == -1 ? "" : s.substring(first, first + len);
    }
}
