package com.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangzhiwen on 2019/9/15.
 * 23432
 */
public class Lcode_9_IsPalindrome {
    public static void main(String[] args) {
    }
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int a=x,b=0;
        while (a>b) {
            b = b * 10 + a % 10;
            a = a / 10;
        }
        return a==b||a==b/10;
    }
}