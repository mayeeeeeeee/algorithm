package com.nowcoder.designPatterns;

/**
 * Created by wangzhiwen on 2019/6/11.
 * 单例模式：其中内部类和枚举法实现单例模式在此不做介绍。
 * 应用场景：线程池、windows任务管理器
 */

/**饿汉模式：类加载时就进行实例化，没有做到延迟加载，线程安全
public class Singleton {
   private static Singleton instance = new Singleton();
   private Singleton(){}
   public static Singleton getIntance(){
       return instance;
   }
}
 */

/**懒汉模式：做到了延迟加载，线程不安全
public class Singleton {
    private static Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance==null)
            instance=new Singleton();
        return instance;
    }
}
 */

/**懒汉模式改良版1：解决了线程不安全的问题，用synchronized关键字修饰方法效率较低
public class Singleton {
    private static Singleton instance = null;
    private Singleton(){}
    public static synchronized Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }
}
 */

/**懒汉模式改良版2（双重校验锁）：锁内移，提高了效率
public class Singleton {
    private static volatile Singleton instance=null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance==null){
            synchronized(Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
 */
