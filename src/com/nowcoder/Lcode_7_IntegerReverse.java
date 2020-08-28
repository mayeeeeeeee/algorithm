package com.nowcoder;

/**
 * Created by wangzhiwen on 2019/9/15.
 */
public class Lcode_7_IntegerReverse {
    public static int reverse(int x){
        int a=x,res=0,b;
        while (a!=0){
            b=a%10;
            if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&b>7)){
                return 0;
            }
            if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&b<-8)){
                return 0;
            }
            res=res*10+b;
            a/=10;
        }
        return res;
    }
}
