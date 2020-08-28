package com.nowcoder.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangzhiwen on 2020/2/7.
 */
public class L15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == 0 - nums[i]) {
                    // if (l - 1 > i && r + 1 <= nums.length - 1 && nums[r] == nums[r + 1] && nums[l] == nums[l - 1]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    while (l < r && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    while (l < r && nums[l + 1] == nums[l]) {
                        l++;
                    }
                    r--;
                    l++;
                }
                else if (sum > 0 - nums[i]) {
                    r--;
                }
                else {
                    l++;
                }
            }
        }
        return res;
    }
}
