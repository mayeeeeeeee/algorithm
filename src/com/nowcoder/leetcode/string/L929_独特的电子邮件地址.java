package com.nowcoder.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangzhiwen on 2019/10/19.
 */
public class L929_独特的电子邮件地址 {
    public static void main(String[] args) {
        String[] in={"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        System.out.println(new L929_独特的电子邮件地址().numUniqueEmails(in));
    }
    public int numUniqueEmails(String[] emails) {
        Set<String> res=new HashSet<>();
        for (String str:emails) {
            int i=0;
            StringBuilder temp=new StringBuilder();
            String[] s = str.split("@");
            while (i<s[0].length()&&s[0].charAt(i)!='+'){
                if(s[0].charAt(i)!='.') temp.append(s[0].charAt(i));
                i++;
            }
            temp.append('@');
            res.add(temp.append(s[1]).toString());
        }
        return res.size();
    }
}
