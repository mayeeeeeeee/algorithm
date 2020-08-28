package com.nowcoder.leetcode.binarySearch;

/**
 * Created by wangzhiwen on 2019/10/9.
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 2 2 4
 * 3 3 9
 * 4 4 16
 * 5 5 25
 */
public class L69_x的平方根 {
    public static void main(String[] args){
        //46340.950001051984 10 0 6
    }
    public int mySqrt(int x) {
        int l=0,r=46340,mid;
        while (l<=r){
            mid=(l+r)/2;//3
            if(x<l*l){
                return l-1;
            }
            if(x>r*r){
                return r;
            }
            if(x==mid*mid){
                return mid;
            }
            else if(x<mid*mid){
                r=mid-1;
            }
            else {//4 6
                l=mid+1;
            }
        }
        return -1;
    }
}
