package com.nowcoder.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhiwen on 2019/10/20.
 */
public class L273_整数转换英文表示 {
    public static void main(String[] args) {
        System.out.println(numberToWords(1204));
    }
    public static String numberToWords(int num) {
        List<Integer> list=new ArrayList<>();//7654321
        int sum=num;
        while (sum>0){
            list.add(sum%10);
            sum/=10;
        }
        String[] a={"Hundred","Thousand","Million","Billion"};//2 3 6 9
        StringBuilder res=new StringBuilder();
        for (int i = list.size()-1; i <=0 ; i--) {
            int temp=0,flag=0;
            while (i+1>9){
                flag=1;
                temp*=temp*10+list.get(i);
                i--;
            }
            if(flag==1){
                res.append(temp);
                res.append(a[3]);
                continue;
            }
            while (i+1>6){
                flag=2;
                temp*=temp*10+list.get(i);
                i--;
            }
            if(flag==2){
                res.append(temp);
                res.append(a[2]);
                continue;
            }
            while (i+1>3){
                flag=2;
                temp*=temp*10+list.get(i);
                i--;
            }
        }
        return "";
    }
}
