package com.learn.cloud.java8;

import org.apache.commons.lang.StringUtils;

import java.util.function.Predicate;

/**
 * 类名称:TestPredicates
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/3/26 15:43
 * Version 1.0
 */
public class TestPredicates {

    public static void main(String[] args) {

        /**
         * Predicate 接口：
         *      只有一个参数的返回布尔类型值的 断言型 接口。
         *      该接口包含多种默认方法，来将 Predicate 组合成其他复杂的逻辑（比如：与，或，非）
         */
        Predicate<String> predicate = str -> StringUtils.length(str) == 5;
        String name = "zhang";
        System.out.println(predicate.test(name));
        System.out.println(predicate.negate().test(name));
        System.out.println(predicate.and(Predicate.isEqual("li4")).test(name));
        System.out.println(predicate.or(Predicate.isEqual("li4")).test(name));
    }
}