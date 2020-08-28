package com.nowcoder.leetcode.dfsSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangzhiwen on 2019/10/25.
 */
public class L216_组合数总和lll {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, n, res, new Stack<Integer>(), 1);
        return res;
    }

    private void dfs(int k, int n, List<List<Integer>> res, Stack<Integer> stack, int curr) {
        if (k == stack.size() && n == 0) {
            res.add(new ArrayList(stack));
        }
        if (n >= curr) {
            for (int i = curr; i <= 9; i++) {
                stack.push(i);
                dfs(k, n - i, res, stack, i + 1);
                stack.pop();
            }
        }
    }

}
