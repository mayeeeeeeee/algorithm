package com.nowcoder.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangzhiwen on 2020/2/11.
 */
public class L46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        dfs(nums, res, new Stack<Integer>(), visited);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Stack<Integer> stack, boolean[] visited) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                stack.push(nums[i]);
                visited[i] = true;
                dfs(nums, res, stack, visited);
                visited[i] = false;
                stack.pop();
            }
        }
    }
}
