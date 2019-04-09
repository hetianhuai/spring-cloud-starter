package com.learn.cloud.volatileSingleton;

import java.util.Arrays;
import java.util.List;

/**
 * 类名称:Test
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/3/25 14:43
 * Version 1.0
 */
public class  Test {
    public Test() {
        System.out.print("默认构造方法！--");
    }

    {
        System.out.print("非静态代码块！--");
    }

    static {
        //System.out.print("静态代码块！--");
    }

    public static void test() {
        System.out.print("静态方法中的内容 !--");
        {
            System.out.print("静态方法中的代码块！--");
        }

    }

    public static void main(String[] args) {
        //Test test = new Test();
        //Test.test();
        List<String> names = Arrays.asList("zhang3", "li4", "wang5");
        names.sort((name1, name2) -> name1.compareTo(name2));
        System.out.println(Arrays.toString(names.toArray()));
    }
}