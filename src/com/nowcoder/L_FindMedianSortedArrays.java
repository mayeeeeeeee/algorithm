package com.nowcoder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangzhiwen on 2019/9/13.
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 来源：力扣（LeetCode）链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class L_FindMedianSortedArrays {
    public static void main(String[] args)
    {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        int flag=0;
        if (x <= 0) {
            x = 0 - x;
            flag=1;
        }
        String str = String.valueOf(x);
        char[] ch=new char[str.length()+flag];
        int i=0;
        if(flag==1){
            ch[i++]='-';
        }
        int r;
        for (int j=0; j < str.length(); j++) {
            ch[i++]=str.charAt(str.length() - j - 1);
        }


        try {
            r=Integer.valueOf(String.valueOf(ch));
        } catch (Exception e) {
            return 0;
        }
        return r;
    }
}
