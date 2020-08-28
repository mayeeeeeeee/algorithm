package com.nowcoder.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhiwen on 2020/2/9.
 */
public class L22_括号生成 {
    int sum = 0;
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] chars = new char[n << 1];
        for (int i = 0; i < n; i++) {
            chars[i] = '(';
            chars[chars.length - i - 1] = ')';
        }
        boolean[] flag = new boolean[n << 1];
        dfs(chars, flag, new StringBuilder(""), res);
        return res;
    }

    private void dfs(char[] chars, boolean[] flag, StringBuilder stringBuilder, List<String> res) {
        if (sum < 0) {
            return;
        }
        if (stringBuilder.length() == chars.length) {
            res.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!flag[i]) {
                if (i > 0 && chars[i] == chars[i - 1] && !flag[i - 1]) {
                    continue;
                }
                flag[i] = true;
                stringBuilder.append(chars[i]);
                if (chars[i] == '(') {
                    sum += 1;
                } else {
                    sum -= 1;
                }
                dfs(chars, flag, stringBuilder, res);
                if (stringBuilder.charAt(stringBuilder.length() - 1) == '(') {
                    sum -= 1;
                } else {
                    sum += 1;
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                flag[i] = false;
            }
        }
    }
}
