package com.nowcoder.leetcode.binarySearch;

/**
 * Created by wangzhiwen on 2019/10/10.
 */
public class L34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        if(nums==null||nums.length==0){
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=l+(r-l>>1);
            if(nums[mid]>=target){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        if(nums[l]!=target){
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        int left=l;
        l=0;
        r=nums.length-1;
        while(l<r){
            int mid=l+(r-l>>1)+1;
            if(nums[mid]<=target){
                l=mid;
            }
            else{
                r=mid-1;
            }
        }
        res[0]=left;
        res[1]=l;
        return res;
    }
}
