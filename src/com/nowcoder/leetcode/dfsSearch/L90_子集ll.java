package com.nowcoder.leetcode.dfsSearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangzhiwen on 2019/10/25.
 */
public class L90_子集ll {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new Stack<Integer>(), 0);
        Arrays.sort(nums);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Stack<Integer> stack, int index) {
        res.add(new ArrayList<>(stack));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            stack.push(nums[i]);
            dfs(nums, res, stack, i + 1);
            stack.pop();
        }
    }
}
