package com.nowcoder.dynamic_programming;

/**
 * Created by wangzhiwen on 2019/5/22.
 * 抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
 */
public class House_Robber {
    public static void main(String[] args) {

    }
    public static int rob(int []nums){
        int a[]=new int[nums.length+1];
        a[0]=0;
        a[1]=nums[0];
        for(int i=2;i<nums.length+1;i++){
            a[i]=Math.max(a[i-1],a[i-2]+nums[i-1]);
        }
        return a[nums.length];
    }
    //优化
    public static int rob1(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
    /**
     * 改编：若房屋为环形，即首尾亦相连，又当如何。
     */
    public int robnew(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robnew(nums, 0, n - 2), robnew(nums, 1, n - 1));
    }

    private int robnew(int[] nums, int first, int last) {
        int pre2 = 0, pre1 = 0;
        for (int i = first; i <= last; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
