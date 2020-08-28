package com.nowcoder.leetcode.binarySearch;

/**
 * Created by wangzhiwen on 2019/10/11.
 */
public class L33_搜索旋转排序数组 {
    public static void main(String[] args) {
        int a[]={4,5,6,7,0,1,2};
        System.out.println(new L33_搜索旋转排序数组().search(a,3));
    }
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        return search2(nums,target,0,nums.length-1);
    }
    public int search2(int[] nums, int target,int l,int r) {
        if(l>r){
            return -1;
        }
        int mid=(r-l)/2+l,res;
        if(nums[l]<=nums[mid]){
            res=search1(nums,target,l,mid);
            if(res!=-1){
                return res;
            }
            else {
                return search2(nums,target,mid+1,r);
            }
        }
        else {
            res=search1(nums,target,mid,r);
            if(res!=-1){
                return res;
            }
            else {
                return search2(nums,target,l,mid-1);
            }
        }
    }
    public int search1(int []nums,int target,int l,int r){
        int mid;
        while (l<=r){
            mid=(r-l)/2+l;
            if (nums[mid]==target){
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
