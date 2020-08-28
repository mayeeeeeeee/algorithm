package com.nowcoder.leetcode.binarySearch;

/**
 * Created by wangzhiwen on 2019/10/12.
 */
public class L162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
