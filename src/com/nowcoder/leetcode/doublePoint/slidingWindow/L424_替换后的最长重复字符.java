package com.nowcoder.leetcode.doublePoint.slidingWindow;

/**
 * Created by wangzhiwen on 2020/2/7.
 */
public class L424_替换后的最长重复字符 {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int l = 0, r = 0, curmax = 0, res = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            map[ch - 'a']++;
            curmax = Math.max(curmax, map[ch - 'a']);
            r++;
            while (curmax + k < r - l) {
                map[s.charAt(l) - 'a']--;
                l++;
            }
            res = Math.max(r - l, res);
        }
        return res;
    }
    //方法二
    public int characterReplacement1(String s, int k) {
        int[] map = new int[26];
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int charMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            charMax = Math.max(charMax, map[index]);
            if (right - left + 1 > charMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}
