package com.nowcoder.questionsTest;

import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

/**
 * Created by wangzhiwen on 2019/7/18.
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> num=new ThreadLocal<>();//ThreadLocal<Integer>相当于一个变量类型如int
    static class MyThreadA extends Thread{//线程类
        @Override
        public void run(){
            for(int i=0;i<3;i++){
                num.set(i);//赋值
                System.out.println(getName() + " threadLocal.get() = " + num.get());
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
//        MyThreadA myThread1 = new MyThreadA();//创建线程myThread1
//        myThread1.setName("myThread1");
//        MyThreadA myThread2 = new MyThreadA();//创建线程myThread2
//        myThread2.setName("myThread2");
//        myThread1.start();
//        myThread2.start();
//        HashMap mp=new HashMap();
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println();

    }
}
