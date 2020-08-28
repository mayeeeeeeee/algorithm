package com.nowcoder.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangzhiwen on 2019/10/19.
 */
public class L3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0,j=0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))>1){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                j++;
            }
            map.put(s.charAt(j),1);
            res=Math.max(res,i-j+1);
        }
        return res;
    }
}
