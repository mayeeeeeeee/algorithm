package com.nowcoder.utils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangzhiwen on 2019/8/8.
 */
public class Utils {
    public static void main(String[] args) {
        DecimalFormat df=new DecimalFormat("0.00");
        Double a=6.6667;
        String str=df.format(a);
        System.out.println(str);
        Scanner sc = new Scanner(System.in);
//        int m=sc.nextInt();
//        for(int i=0;i<m;i++){
//
//        }
    }
    public static void listall(List list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

}
