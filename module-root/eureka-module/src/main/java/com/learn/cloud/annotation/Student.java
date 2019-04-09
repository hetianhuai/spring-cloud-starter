package com.learn.cloud.annotation;

import lombok.Data;

import java.util.Comparator;

/**
 * 类名称:Student
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/3/25 11:02
 * Version 1.0
 */
@Data
public class Student implements Comparator {
    int age;

    @Override
    public int compare(Object o1, Object o2) {
        return ((Student)o1).age - ((Student)o2).age;
    }
}