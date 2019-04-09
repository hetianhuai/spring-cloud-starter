package com.learn.cloud.annotation;

import java.lang.annotation.*;

/**
 * 类名称:MyAnno
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/3/20 17:09
 * Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface MyAnno {
    public String mName() default "name";
    public int mAge() default 0;
}