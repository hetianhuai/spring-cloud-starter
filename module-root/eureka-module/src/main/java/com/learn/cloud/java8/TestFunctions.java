package com.learn.cloud.java8;

import io.micrometer.core.instrument.util.StringUtils;

import java.util.function.Function;

/**
 * 类名称:TestFunctions
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/3/26 15:43
 * Version 1.0
 */
public class TestFunctions {

    public static void main(String[] args) {

        /**
         * Function 接口：
         *      接受一个参数并生成结果。
         *      默认方法可用于，将多个函数链接在一起（compose, andThen）
         */
        Function<String, String> function1 = s -> s.toUpperCase();
        Function<String, String> function2 = s -> s.concat("2019/03/26");
        Function<String, String> function3 = function1.andThen(function2);

        System.out.println(function3.apply("aBc"));
    }
}