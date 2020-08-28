package com.nowcoder.double_pointer;

/**
 * Created by wangzhiwen on 2019/5/29.
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 */
public class TwoSquareSum {
    public boolean judgeSquareSum(int c) {
        int l=0,r=(int)Math.sqrt(c);
        while (l<r){
            if(l*l+r*r==c){
                return true;
            }
            else if(l*l+r*r<c){
                l++;
            }
            else r--;
        }
        return false;
    }
}
