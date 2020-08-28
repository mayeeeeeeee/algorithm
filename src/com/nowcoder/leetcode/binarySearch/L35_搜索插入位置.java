package com.nowcoder.leetcode.binarySearch;

/**
 * Created by wangzhiwen on 2019/10/9.
 */
public class L35_搜索插入位置 {
    public static void main(String[] args) {

    }
    public int searchInsert(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return -1;
        }
        int l=nums[0],r=nums.length-1,mid;
        while (l<=r){
            mid=(l+r)/2;
            if(nums[l]>target){
                return l-1;
            }
            if(nums[r]<target){
                return r;
            }
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else {
                r=mid-1;
            }
        }
        return -1;
    }
}
