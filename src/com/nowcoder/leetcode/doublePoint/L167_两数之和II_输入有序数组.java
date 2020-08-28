package com.nowcoder.leetcode.doublePoint;

/**
 * Created by wangzhiwen on 2020/2/6.
 */
public class L167_两数之和II_输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        while (l<r){
            if(numbers[l]+numbers[r]==target){
                return new int[]{l + 1, r + 1};
            }
            else if(numbers[l]+numbers[r]<target){
                l++;
            }
            else r--;
        }
        return null;
    }
}
