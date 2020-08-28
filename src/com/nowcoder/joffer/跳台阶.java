package com.nowcoder.joffer;

/**
 * Created by wangzhiwen on 2019/10/5.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class 跳台阶 {
    public int JumpFloor(int target) {
        int n1=1,n2=2;
        if(target<3){
            return target;
        }
        for (int i = 3; i <=target ; i++) {
            int temp=n2;
            n2=n1+n2;
            n1=temp;
        }
        return n2;
    }
}
