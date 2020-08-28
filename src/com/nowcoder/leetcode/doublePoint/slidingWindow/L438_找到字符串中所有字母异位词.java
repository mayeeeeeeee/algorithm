package com.nowcoder.leetcode.doublePoint.slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhiwen on 2020/2/7.
 */
public class L438_找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        System.out.println(new L438_找到字符串中所有字母异位词().findAnagrams("cbaebabacd","abc"));
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int cnt = 0, l = 0, r = 0, now = 0;
        int[] mapp = new int[26], maps = new int[26];
        for (int i = 0; i < p.length(); i++) {
            mapp[p.charAt(i) - 'a']++;
            if (mapp[p.charAt(i) - 'a'] == 1) {
                cnt++;
            }
        }
        while (r < s.length()) {
            char ch = s.charAt(r);
            maps[ch - 'a']++;
            if (maps[ch - 'a'] == mapp[ch - 'a']) {
                now++;
            }
            r++;
            while (cnt == now) {
                maps[s.charAt(l) - 'a']--;
                if (maps[s.charAt(l) - 'a'] == mapp[s.charAt(l) - 'a'] - 1) {
                    now--;
                }
                if(r-l==p.length()){
                    res.add(l);
                }
                l++;
            }
        }
        return res;
    }
}
