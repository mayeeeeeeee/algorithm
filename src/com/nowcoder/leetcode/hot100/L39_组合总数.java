package com.nowcoder.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangzhiwen on 2020/2/11.
 */
public class L39_组合总数 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        dfs(candidates, target, res, new Stack<Integer>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, Stack<Integer> stack, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            stack.push(candidates[i]);
            dfs(candidates, target - candidates[i], res, stack, i);
            stack.pop();
        }
    }
}
