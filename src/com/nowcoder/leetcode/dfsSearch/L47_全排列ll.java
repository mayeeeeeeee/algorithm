package com.nowcoder.leetcode.dfsSearch;

import java.util.*;

/**
 * Created by wangzhiwen on 2019/10/24.
 */
public class L47_全排列ll {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, res, new Stack<Integer>(), visited);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Stack<Integer> stack, boolean[] visited) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                stack.push(nums[i]);
                visited[i] = true;
                dfs(nums, res, stack, visited);
                visited[i] = false;
                stack.pop();
            }
        }
    }
}
