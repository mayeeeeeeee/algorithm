package com.nowcoder.dynamic_programming;

import java.util.Scanner;

/**
 * Created by wangzhiwen on 2019/5/25.
 * 给定一个无序的整数数组，找出最长递增子序列
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 思路；找到每个可能的已7结尾的递增子序列，找出最长的。
 */
public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length<2){
            return nums.length;
        }
        int []dp=new int[nums.length];//需要dp[i-1]则开大1，从1开始
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);//之前所有满足条件最大的和这次比较
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int p[]=new int[m];
        for (int i = 0; i < m; i++) {
            p[i]=sc.nextInt();
        }
        System.out.println(lengthOfLIS(p));
    }
    //思想同Combine_Number45
}


