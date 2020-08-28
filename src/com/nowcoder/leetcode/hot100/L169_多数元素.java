package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/1.
 */
public class L169_多数元素 {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1, cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {
                count++;
            }
            else {
                count--;
            }
//            if (count == 0 && i + 1 < nums.length) {
            if (count == 0) {//前提众数存在
                cur = nums[i + 1];
            }
        }
        return cur;
    }
}
