package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/2.
 */
public class L283_移动零 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i <nums.length ; i++) {
            nums[i] = 0;
        }
    }
}
