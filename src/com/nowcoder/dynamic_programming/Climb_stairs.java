package com.nowcoder.dynamic_programming;

/**
 * Created by wangzhiwen on 2019/5/15.
 * 每次你可以爬 1 或 2 个台阶,到达n的“前一步”走法可以是：从n-1处爬1阶楼梯，或者从n-2处爬2阶楼梯。
 * S(n) = S(n-1) + S(n-2)
 */
public class Climb_stairs {
    public static void main(String[] args) {
        int n=3;
        int a=1,b=1,c=0;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        System.out.println(c);
    }
}
