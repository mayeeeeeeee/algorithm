package com.nowcoder.joffer;

/**
 * Created by wangzhiwen on 2019/10/5.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class 变态跳台阶 {
    public int JumpFloorII(int target) {
        int a[]=new int[target+1];
        a[0]=0;
        int sum=0;
        for (int i = 1; i <=target ; i++) {
            a[i]=sum+1;
            sum+=a[i];
        }
        return sum;
    }
}
