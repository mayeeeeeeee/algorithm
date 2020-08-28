package com.learning;

import javax.swing.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wangzhiwen on 2019/8/9.
 * https://blog.csdn.net/jmj18756235518/article/details/81490978
 * https://www.cnblogs.com/linzhanfly/p/9686941.html  java.util.function
 * http://www.imooc.com/article/252935?block_id=tuijian_wz    范型
 * https://segmentfault.com/a/1190000016596774?utm_source=tag-newest  函数式接口
 */
public class Lambda {
    public static void main(String[] args) {
        //Stream.iterate(0, x -> x + 2).limit(10).forEach(System.out::println);//遍历无限流
        //Stream.generate(Math::random).limit(10).forEach(System.out::println);//生成无限流
//        Stream<ArrayList> generate = Stream.generate(()->new ArrayList());
        List<String> a = new ArrayList();
        a.add("1");
        a.add("2");
        a.add("2");
        a.add("3");
//        Stream<String> stream = a.stream();
//        List<String> collect = stream.collect(Collectors.toList());//stream转集合
//        stream.forEach(System.out::println);//foreach
//        String[] array={"123","456","789"};
//        Stream<String> distinct = stream.distinct();
//        a.sort(Comparator.comparing(Integer::parseInt));
        String s = a.stream().max(Comparator.comparing(Integer::parseInt)).get();
        System.out.println(s);
        Function<Integer, String[]> fun = String[]::new;
        String aa[]={"3","5","1"};
        Arrays.sort(aa,Comparator.comparing(Integer::parseInt));
    }
}
