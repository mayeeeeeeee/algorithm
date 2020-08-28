package com.nowcoder.leetcode.dp;

import java.util.List;

/**
 * Created by wangzhiwen on 2020/2/2.
 */
/*
state      :
function   :
initialize :
answer     :
*/
public class test {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int [] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

}
/*
state      :
function   :
initialize :
answer     :
*/

//            System.out.println(i + " " + j + " " + dp[i][j]);