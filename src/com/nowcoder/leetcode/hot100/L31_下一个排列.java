package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/10.
 */
public class L31_下一个排列 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (nums.length == 1) {
            System.out.println(nums[0]);
        }
        int  i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] <= nums[i + 1 ]) {
                break;
            }
        }
        int j = i + 1;
        for (; j < nums.length; j++) {
            if (nums[i] > nums[j]) {
                break;
            }
        }
    }
}
