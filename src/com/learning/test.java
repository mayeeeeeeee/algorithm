package com.learning;

/**
 * Created by wangzhiwen on 2019/5/21.
 */
public class test {
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
        MyThreadA myThread1 = new MyThreadA();//创建线程myThread1
        myThread1.setName("myThread1");
        MyThreadA myThread2 = new MyThreadA();//创建线程myThread2
        myThread2.setName("myThread2");
        myThread1.start();
        myThread2.start();
    }
}
