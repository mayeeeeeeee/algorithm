package com.nowcoder.leetcode.hot100;

import java.util.*;

/**
 * Created by wangzhiwen on 2019/10/17.
 */
public class L49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] k = strs[i].toCharArray();
            Arrays.sort(k);
            String key = String.valueOf(k);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> v = new ArrayList<>();
                v.add(strs[i]);
                map.put(key, v);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String str :
                map.keySet()) {
            res.add(map.get(str));
        }
        return res;
    }

}
