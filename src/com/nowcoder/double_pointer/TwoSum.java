package com.nowcoder.double_pointer;

/**
 * Created by wangzhiwen on 2019/5/29.
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int []res=new int[2];
        int l=0,r=numbers.length-1;
        while (l<r){
            if(numbers[l]+numbers[r]==target){
                res[0]=l+1;
                res[1]=r+1;
                return res;
            }
            else if(numbers[l]+numbers[r]<target){
                l++;
            }
            else r--;
        }
        return res;
    }
}
