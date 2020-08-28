package com.nowcoder.dynamic_programming;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangzhiwen on 2019/5/28.
 * 最长公共子序列
 * in: abcdefg abxdefg
 * out:4(defg)
 */
public class LongestSameString {
    public boolean validPalindrome(String s) {
        boolean res=false;
        int flag = 1;
        int l = 0, r = s.length() - 1;
        while (l<r){
           if(s.charAt(l)==s.charAt(r)){
               l--;
               r--;
           }
           else if(flag==1){
               flag--;

           }
        }
        return res;
    }
}
