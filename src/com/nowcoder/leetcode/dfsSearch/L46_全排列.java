package com.nowcoder.leetcode.dfsSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangzhiwen on 2019/10/24.
 */
public class L46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, res, new Stack<Integer>());
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<List<Integer>> res, Stack<Integer> stack) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                stack.push(nums[i]);
                visited[i] = true;
                dfs(nums, visited, res, stack);
                visited[i] = false;
                stack.pop();
            }
        }
    }
}
