package com.nowcoder.leetcode.doublePoint.slidingWindow;

/**
 * Created by wangzhiwen on 2020/2/7.
 */
public class L567_字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        int[] map1 = new int[26], map2 = new int[26];
        int l = 0, r = 0, cnt = 0, now = 0;
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
            if (map1[s1.charAt(i) - 'a'] == 1) {
                cnt++;
            }
        }
        while (r < s2.length()) {
            map2[s2.charAt(r) - 'a']++;
            if (map2[s2.charAt(r) - 'a'] == map1[s2.charAt(r) - 'a']) {
                now++;
            }
            r++;
            while (now == cnt) {
                if (r - l == s1.length()) {
                    return true;
                }
                map2[s2.charAt(l) - 'a']--;
                if (map2[s2.charAt(l) - 'a'] == map1[s2.charAt(l) - 'a'] - 1) {
                    now--;
                }
                l++;
            }
        }
        return false;
    }
}
