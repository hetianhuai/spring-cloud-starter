package com.learn.cloud.volatileSingleton;

/**
 * 类名称:Singleton
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/3/25 11:34
 * Version 1.0
 */

/**
 * 双重检查+volatile实现懒汉式单例模式
 */
public class Singleton {

    private static volatile Singleton INSTANCE;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if(INSTANCE == null){
            synchronized (Singleton.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}

/**
 * 静态内部类实现懒汉式单例模式：既可延迟初始化，也支持线程安全
 */
class SingletonStatic {

    private SingletonStatic (){

    }

    private static class LazyHolder{
        private static SingletonStatic INSTANCE = new SingletonStatic();
    }

    public static SingletonStatic getInstance(){
        return LazyHolder.INSTANCE;
    }
}

/**
 * 饿汉式单例模式不存在线程安全问题
 */