package com.nowcoder.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangzhiwen on 2020/2/16.
 */
public class L78_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, new Stack<Integer>(), res, 0);
        return res;
    }

    private void dfs(int[] nums, Stack<Integer> stack, List<List<Integer>> res, int index) {
        res.add(new ArrayList<>(stack));
        for (int i = index; i < nums.length; i++) {
            stack.push(nums[i]);
            dfs(nums, stack, res, i + 1);
            stack.pop();
        }
    }
}
