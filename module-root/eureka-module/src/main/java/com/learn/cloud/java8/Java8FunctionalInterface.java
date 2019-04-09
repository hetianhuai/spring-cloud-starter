package com.learn.cloud.java8;

import lombok.Data;
import org.springframework.core.convert.converter.Converter;

/**
 * 类名称:Java8FunctionalInterface
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/3/26 14:43
 * Version 1.0
 */
@FunctionalInterface
public interface Java8FunctionalInterface {

    /**
     * 函数式接口有且仅有一个抽象方法，但可以有多个default方法
     */
    void method1();

    //void method2();

    default void defaultMentod1(){}

    default void defaultMentod2(){}
}
class Java8FunctionalInterfaceTest1{

    void doMethod(){
        System.out.println("doMethod");
    }

    String doSomething(String s){
        return "doSomething" + s;
    }

    public static void main(String[] args) {
        /**
         * 1.Lambda方式创建函数式接口对象
         */
        Java8FunctionalInterface sun = () -> System.out.println("sun method");
        sun.method1();
        sun.defaultMentod1();
    }
}
class Java8FunctionalInterfaceTest2{

    public static void main(String[] args) {
        /**
         * 2.::传递静态方法的引用
         */
        Converter<String, Integer> converter1 = Integer::valueOf;// 传递Integer.valueOf()引用
        System.out.println(converter1.convert("10086").getClass());

        /**
         * 3.::传递对象方法的引用，需要先创建对象
         */
        Java8FunctionalInterfaceTest1 test1 = new Java8FunctionalInterfaceTest1();

        Converter<String, String> converter2 = test1::doSomething;
        System.out.println(converter2.convert(" li4"));

        Java8FunctionalInterface sun = test1::doMethod;
        sun.method1();

        /**
         * 4.::传递构造方法的引用
         */
        Creater creater = Man::new;
        Man man = creater.create("zhang3", 20);
        man.toStr();
    }
}
interface Creater<MM extends Man>{

    MM create(String name, Integer age);
}
@Data
class Man{
    String name;
    Integer age;
    public Man(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public void toStr(){
        System.out.println(name + age);
    }
}