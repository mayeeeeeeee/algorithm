package com.nowcoder.leetcode.binarySearch;

import java.util.Arrays;

/**
 * Created by wangzhiwen on 2020/2/13.
 */
public class Li183_木材加工 {
    public int woodCut(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        if (k > sum) {
            return 0;
        }
        int l = 1, r = max;
        while (l < r) {
            int mid = l + (r - l + 1>> 1), cnt = 0;
            for (int num : nums) {
                cnt += num / mid;
            }
            if (cnt >= k) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }
        return l;
    }
}
