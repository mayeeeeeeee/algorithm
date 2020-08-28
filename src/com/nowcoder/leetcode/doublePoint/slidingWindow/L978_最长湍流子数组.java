package com.nowcoder.leetcode.doublePoint.slidingWindow;

/**
 * Created by wangzhiwen on 2020/2/7.
 */
public class L978_最长湍流子数组 {
    //滑动窗口解法
    public int maxTurbulenceSize(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int r = 2, l = 0, res = 2;
        int cur = nums[1] > nums[0] ? 1 : 0;//false
        while (r < nums.length) {
            if (((nums[r] > nums[r - 1] ? 1 : 0) ^ cur) == 1) {
                l = r - 1;
            }
            cur = nums[r] > nums[r - 1] ? 1 : 0;
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    //动态规划解法
}
