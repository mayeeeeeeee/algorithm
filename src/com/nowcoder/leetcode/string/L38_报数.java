package com.nowcoder.leetcode.string;

/**
 * Created by wangzhiwen on 2019/10/17.
 */
public class L38_报数 {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String str=countAndSay(n-1);
        StringBuilder res=new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            int k=i;
            while (k<str.length()&&str.charAt(k)==str.charAt(i)) k++;
            res.append(k-i);
            res.append(str.charAt(i));
            i=k-1;
        }
        return res.toString();
    }
}
