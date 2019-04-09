package com.learn.cloud.java8;

/**
 * 类名称:Java8Interface
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/3/26 13:48
 * Version 1.0
 */
public interface Java8Interface {

    /**
     * 1.实现类只需要实现抽象方法，默认方法可以直接使用
     */
    default void defaultMethod(){
        System.out.println("defaultMethod");
    }

    default void defaultMethod2() {
        System.out.println("defaultMethod2");
    }

    void method();

    void method2();
}
class Java8InterfaceSun implements Java8Interface{

    @Override
    public void method() {
        defaultMethod();
        System.out.println("sun method");
    }

    @Override
    public void method2() {
        System.out.println("sun method2");
    }
}
class Java8InterfaceTest{

    public static void main(String[] args) {
        Java8Interface sun = new Java8InterfaceSun();
        sun.method();

        /**
         * 2.可以通过匿名内部类方式，创建对象访问默认方法
         */
        Java8Interface inner = new Java8Interface() {
            @Override
            public void method() {
                defaultMethod();
                System.out.println("inner method");
            }

            @Override
            public void method2() {
                System.out.println("inner method2");
            }
        };
        inner.defaultMethod2();
        inner.method();

        /**
         * 3.Lambda方式创建接口对象时，接口只能有一个抽象方法
         *      即函数式接口@FunctionalInterface，有且仅有一个抽象方法
         */
        //Java8Interface lambda = () -> System.out.println("hello");
    }
}