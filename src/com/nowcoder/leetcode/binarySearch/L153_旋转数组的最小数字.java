package com.nowcoder.leetcode.binarySearch;

/**
 * Created by wangzhiwen on 2019/10/11.
 */
public class L153_旋转数组的最小数字 {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] < nums[h]) {//若mid前后都有序，则找前
                h=m;
            } else {
                l=m+1;
            }
        }
        return nums[l];
}}
