package com.nowcoder;

import com.nowcoder.utils.Utils;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wangzhiwen on 2019/8/8.
 *
 */
public class BeiKe_BigInteger {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        String min = "10000000000000000",b=sc.next(),a,minl="",minr="";
        java.math.BigInteger minb=new java.math.BigInteger(min),bb=new java.math.BigInteger(b),temp;
        for (int i = 1; i < m; i++) {
            a=sc.next();
            java.math.BigInteger ab=new java.math.BigInteger(a);
            temp=bb.subtract(ab).abs();
            System.out.println(bb.toString()+" "+ab.toString()+" "+temp.toString());
            if(temp.compareTo(minb)<0){
                minb=temp;
                minl=b;
                minr=a;
            }
            bb=ab;
            b=a;
        }
        System.out.println(minl+" "+minr);
    }
}
