package com.nowcoder.leetcode.dfsSearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wangzhiwen on 2019/10/29.
 */
public class L473_火柴拼正方形{
    public static void main(String[] args) {
        int[] a = {5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4};
        System.out.println(new L473_火柴拼正方形().makesquare(a));
    }
    public boolean makesquare(int[] nums) {
        Arrays.sort(nums);
        boolean flag[]=new boolean[nums.length];
        int sum=0;
        for(int i:nums) sum+=i;
        if(sum%4!=0||sum<4){
            return false;
        }
        return dfs(nums,flag,0,0,sum/4);
    }

    private boolean dfs(int[] nums, boolean[] flag, int cnt, int cur, int len) {
        if(cur==len) {
            cnt++;
            cur=0;
        }
        if(cnt==4) return true;
        for (int i = nums.length-1; i >=0; i--) {
            if(nums[i]>len){
                return false;
            }
            if(!flag[i]&&cur+nums[i]<=len){
                flag[i]=true;
                if(dfs(nums,flag,cnt,cur+nums[i],len)){
                    return true;
                }
                flag[i]=false;
                while(i-1>=0&&nums[i-1]==nums[i]) i--;
                if(cur==0||cur+nums[i]==len) return false;
            }
        }
        return false;
    }
}
