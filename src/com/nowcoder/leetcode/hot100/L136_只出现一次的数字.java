package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/1/30.
 */
public class L136_只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
