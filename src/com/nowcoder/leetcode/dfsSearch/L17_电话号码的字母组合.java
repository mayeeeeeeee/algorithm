package com.nowcoder.leetcode.dfsSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzhiwen on 2019/10/22.
 */
public class L17_电话号码的字母组合 {
    String[] strings = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        dfs(res, digits.toCharArray(), new StringBuilder(""), 0);
        return res;
    }

    private void dfs(List<String> res, char[] digits, StringBuilder temp, int index) {
        if (index == digits.length) {
            res.add(temp.toString());
            return;
        }
        char[] chars = strings[digits[index] - 2].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            temp.append(chars[i]);
            dfs(res, digits, temp, i + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
