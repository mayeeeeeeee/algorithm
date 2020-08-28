package com.nowcoder.leetcode.doublePoint.slidingWindow;

/**
 * Created by wangzhiwen on 2020/2/5.
 */
public class L209_长度最小的子数组 {
    //leetcode模版
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = 0, sum = 0, res = Integer.MAX_VALUE;
        while (r < nums.length) {
            while (sum >= s) {
                res = Math.min(res, r - l);
                sum -= nums[l];
                l++;
            }
            sum += nums[r];
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    //九章模版
    public int minSubArrayLen1(int s, int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j++];
            }
            if (sum >= s) {
                min = Integer.min(min, j - i);
                sum -= nums[i];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
