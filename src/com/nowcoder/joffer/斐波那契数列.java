package com.nowcoder.joffer;

/**
 * Created by wangzhiwen on 2019/10/5.
 */
public class 斐波那契数列 {
    public int Fibonacci(int n) {
        int n1=1,n2=1;
        if(n==1||n==2){
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            int temp=n2;
            n2=n1+n2;
            n1=temp;
        }
        return n2;
    }
}
