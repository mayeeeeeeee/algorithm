package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/1/27.
 * tips：明确变量的意义(sum)
 */
public class L53_最大子序和 {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int max=nums[0],sum=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(sum<0) sum=nums[i];
            else {
                sum+=nums[i];
            }
            max=Math.max(sum,max);
        }
        return max;
    }
}
