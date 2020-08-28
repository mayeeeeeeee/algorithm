package com.nowcoder.leetcode.string;

/**
 * Created by wangzhiwen on 2019/10/19.
 */
public class L6_Z字形变换 {
    public String convert(String s, int numRows) {
        int m=numRows+numRows-2;
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int f=i,c=m;
            while (f<s.length()){
                res.append(s.charAt(f));
                if(c!=0&&c!=m&&f+c<s.length()){
                    res.append(s.charAt(f+c));
                }
                f+=m;
                c-=2;
            }
        }
        return res.toString();
    }
}
