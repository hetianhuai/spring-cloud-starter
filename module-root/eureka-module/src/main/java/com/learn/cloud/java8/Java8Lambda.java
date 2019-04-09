package com.learn.cloud.java8;

import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 类名称:Java8Lambda
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/3/26 13:56
 * Version 1.0
 */
public class Java8Lambda {

    /**
     * 1.Lambda简洁语法
     * @param args
     */
    public static void main(String[] args) {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        /*Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });*/
        names.sort((a, b) -> a.compareTo(b));
        System.out.println(Arrays.toString(names.toArray()));
    }
}
class Java8LambdaTestField1{

    /**
     * 2.Lambda可访问外部的局部变量
     *      和匿名对象不同的是，变量可以不用声明为final
     *      不过变量不可被Lambda之后的代码修改，即隐性的具有final的语义
     * @param args
     */
    public static void main(String[] args) {
        int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        String result = stringConverter.convert(2);
        System.out.println(result);
        //num = 5;
    }
}
class Java8LambdaTestField2{

    int outerNum;
    static int outerStaticNum;

    void test(){
        Converter<Integer, String> stringConverter1 = (from) -> String.valueOf(from + ++outerNum);
        Converter<Integer, String> stringConverter2 = (from) -> String.valueOf(from + ++outerStaticNum);
        System.out.println(outerNum);
        System.out.println(outerStaticNum);
        System.out.println(stringConverter1.convert(1));
        System.out.println(stringConverter2.convert(1));
        System.out.println(outerNum);
        System.out.println(outerStaticNum);
    }

    /**
     * 3.Lambda可访问外部的成员变量和静态成员变量
     * @param args
     */
    public static void main(String[] args) {
        Java8LambdaTestField2 obj = new Java8LambdaTestField2();
        obj.test();
    }
}
class Java8LambdaTestInterface{

    /**
     * 4.Lambda中无法访问Java8接口的默认方法
     * @param args
     */
    public static void main(String[] args) {
        Java8Interface sun1 = new Java8Interface() {
            @Override
            public void method() {
                defaultMethod();
            }

            @Override
            public void method2() {
                defaultMethod2();
            }
        };

        /*Java8Interface sun2 = () -> {
            defaultMethod();
            System.out.println("Can Not Visit Java8 Interface Default Method!");
        };
        sun2.method();*/
    }
}