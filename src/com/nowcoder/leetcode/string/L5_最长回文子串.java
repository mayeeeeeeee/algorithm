package com.nowcoder.leetcode.string;

/**
 * Created by wangzhiwen on 2019/10/19.
 */
public class L5_最长回文子串 {
    public static void main(String[] args) {
        System.out.println(new L5_最长回文子串().longestPalindrome("dddddddd"));
    }
    public String longestPalindrome(String s) {
        String res="";
        for(int i=0;i<s.length();i++){
            int j=i,k=i;
            for(;j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k);j--,k++);
            if(k-j-1>res.length()){
                res=s.substring(j+1,k);
            }
            j=i;
            k=i+1;
            for(;j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k);j--,k++) ;
            if(k-j-1>res.length()){
                res=s.substring(j+1,k);
            }
        }
        return res;
    }
}
