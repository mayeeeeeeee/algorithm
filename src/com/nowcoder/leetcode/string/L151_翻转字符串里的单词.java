package com.nowcoder.leetcode.string;

/**
 * Created by wangzhiwen on 2019/10/17.
 */
public class L151_翻转字符串里的单词 {
    public String reverseWords(String s) {
//        if(s.length()==0) return "";
        char[] res=new char[s.length()];
        int k=0;
        for (int i = 0; i < s.length(); i++) {
            int j=i;
            while (j<s.length()&&s.charAt(j)==' ') j++;
            i=j;
            if(j==s.length()) break;
            while (j<s.length()&&s.charAt(j)!=' ') j++;
            for (int l=0; l <j-i ; l++) {
                res[k++]=s.charAt(j-1-l);
            }
            if(k!=0){
                res[k++]=' ';
            }
            i=j-1;
        }
        StringBuilder r=new StringBuilder(String.valueOf(res,0,k)).reverse();
        if(r.length()!=0){
            return r.substring(1);
        }
        return "";
    }
}
