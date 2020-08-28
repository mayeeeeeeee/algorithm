package com.nowcoder.leetcode.dfsSearch;

import java.util.*;

/**
 * Created by wangzhiwen on 2019/10/25.
 */
public class L78_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new Stack<Integer>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Stack<Integer> stack, int index) {
        res.add(new ArrayList<>(stack));
        for (int i = index; i < nums.length; i++) {
            stack.push(nums[i]);
            dfs(nums, res, stack, i + 1 );
            stack.pop();
        }
    }
}
