package com.nowcoder;
import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.*;

/**
 *字符串自己处理用char []chars= str.toCharArray(),方法处理用String[] strs=str.split("");

 排序函数 Collection.sort(list,顺序（默认正序）)
 list.sort(顺序)
 字符数组/StringBuffer/StringBuilder转为String new String(传入待转)
 Arrays.asList(array)返回的ArrayList对象（属于Arrays内部类）需转为集合对象才可进一步操作new ArrayList(传入待转)
 比如int[]，double[]，char[]等基数据类型的数组，Arrays类之只是提供了默认的升序排列，没有提供相应的降序排列方法。
 要对基础类型的数组进行降序排序，需要将这些数组转化为对应的封装类数组（或List）

 Comparable & Comparator 都是用来实现集合中的排序的，
 只是 Comparable 是在对象内部定义的方法实现的排序，实现需重写compareTO，Comparator 是在对象外部实现的排序（）更灵活，实现须
 重写compare，基本类包装类实现了Comparable。

 可使用匿名内部类或Labmda表达式（取代函数式接口的匿名内部类）重写compareTO方法
 */

public class Comparetest {
    public static void main(String[] args) {
        System.out.println( sort("fedcba","ee"));
    }
    public static String sort(String a,String b){
        String []aa=a.split("");
        String[] bb = b.split("");
        List<String>la=new ArrayList<>(Arrays.asList(aa));
        List<String>lb=new ArrayList<>(Arrays.asList(bb));
        la.sort((x,y)->(y.compareTo(x)));
        lb.sort((x,y)->(y.compareTo(x)));

        int lla=0,llb=0,r=0;
        StringBuffer res=new StringBuffer();
        while (lla<la.size()&&llb<lb.size()){
            if(la.get(lla).compareTo(lb.get(llb))<0){
                res.append(lb.get(llb++).charAt(0));
                lla++;
            }
            else {
                res.append(la.get(lla++).charAt(0));

            }
        }
        while (lla<la.size()){
            res.append(la.get(lla++).charAt(0));
        }
        while (llb<lb.size()){
            res.append(lb.get(llb++).charAt(0));
        }

        return new String(res);
    }
}