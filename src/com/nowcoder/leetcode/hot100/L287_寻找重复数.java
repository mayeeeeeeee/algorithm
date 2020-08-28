package com.nowcoder.leetcode.hot100;

/**
 * Created by wangzhiwen on 2020/2/28.
 */
public class L287_寻找重复数 {
    public int findDuplicate(int[] nums) {
        int n=nums.length-1;
        int l=1,r=n;
        while(l<r){
            int mid=l+(r-l+1>>1);
            int cnt=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>=mid&&nums[i]<=r){
                    cnt++;
                }
            }
            if(cnt>r-mid+1){
                l=mid;
            }
            else{
                r=mid-1;
            }
        }
        return l;
    }
}
