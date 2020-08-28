package com.learning;

import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by wangzhiwen on 2019/8/19.
 */
public class Jdk8 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList();
        list.add(3);
        list.add(5);
        list.add(1);
        list.stream().max(Integer::compareTo);
        int []nums = {2, 1, 5};
        System.out.println(Arrays.stream(nums).max().getAsInt());
    }
}
