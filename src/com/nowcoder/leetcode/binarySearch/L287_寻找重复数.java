package com.nowcoder.leetcode.binarySearch;


import java.util.Arrays;

/**
 * Created by wangzhiwen on 2019/10/13.
 */
public class L287_寻找重复数 {
    public int findDuplicate(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int l=1,r=nums.length-1;
        while (l<r){
            int mid=l+(r-l>>1),cnt=0;
            for (int i = 0; i <nums.length ; i++) {
                if(nums[i]>0&&nums[i]<=mid){
                    cnt++;
                }
            }
            if(cnt>mid){
                r=mid;
            }
            else {
                l=mid+1;
            }
        }
        return l;
    }
}
