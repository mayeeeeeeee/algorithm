package com.learning;

import com.sun.tools.jdi.InternalEventHandler;
import sun.jvm.hotspot.utilities.soql.Callable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;

/**
 * Created by wangzhiwen on 2019/5/21.
 * 3种方法创建线程
 * 匿名内部类与lamda表达式  https://www.cnblogs.com/CarpenterLee/p/5978721.html
 */
public class ThreadCreate {
    public static void main(String[] args) {

        //1.实现Runnable，重写run方法(匿名内部类)。
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
            //lamda表达式（省略接口名和方法名）
        new Thread(()->{
            System.out.println(123);
        }).start();


        //2.实现Callable，重写call方法(匿名内部类)
        new Thread(new FutureTask<Integer>(new java.util.concurrent.Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 123;
            }
        }) {
        }).start();
            //lamda表达式
        new Thread(new FutureTask<Integer>(()->{
           return 123;
        })).start();



        //3.继承Thread,重写run方法（匿名内部类）
        new Thread(){
            @Override
            public void run(){

            }
        }.start();
            //无法使用lamda表达式，非函数时接口

    }
    
}

