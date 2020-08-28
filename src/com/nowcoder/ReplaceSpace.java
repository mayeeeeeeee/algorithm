package com.nowcoder;

/**
 * Created by wangzhiwen on 2018/11/14.
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuilder res = new StringBuilder();
        String str_string=str.toString();
        char[] chars=str_string.toCharArray();
        int len = chars.length;
        for (int i = 0 ; i<len;i++){
            if (chars[i]==' ')
                res.append("%20");
            else
                res.append(chars[i]);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        ReplaceSpace rep = new ReplaceSpace();
        System.out.println(rep.replaceSpace(new StringBuffer("hello world")));
    }
}
