package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/27.
 */
public class L238_除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = 1;
            }
            else {
                res[i] = res[i - 1] * nums[i - 1];
            }
        }
        int k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;
    }
}
