package com.learn.cloud.java8;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类名称:Java8Streams
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/3/26 15:42
 * Version 1.0
 */
public class Java8Streams {

    public static void main(String[] args) {
        /**
         * Stream操作：
         *      分为中间操作或者最终操作两种，
         *      最终操作返回一特定类型的计算结果，
         *      中间操作返回Stream本身
         * 1.Stream中间操作:
         *      filter，sorted，map
         *      不会影响原有的数据源
         */
        List<String> list = Arrays.asList("mm", "bb", "ccc", "dd", "ee");
        list.stream()
                .filter(s -> s.length() == 2)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .map(s -> s.toUpperCase().concat("."))
                .forEach(s -> System.out.println(s));
        System.out.println(StringUtils.join(list, ","));
    }
}
class Java8StreamsTest{

    public static void main(String[] args) {
        /**
         * 2.Stream最终操作：
         *      match，count，reduce
         */
        List<String> list = Arrays.asList("mm", "bb", "ccc", "dd", "ee");

        //System.out.println(list.stream().allMatch(s -> s.length() == 2));
        //System.out.println(list.stream().noneMatch(s -> s.length() == 4));
        System.out.println(list.stream().anyMatch(s -> s.length() == 2));

        System.out.println(list.stream().filter(s -> s.length() == 2).count());
        System.out.println(list.stream().reduce((String a, String b) -> a.concat("#").concat(b)).get());
        //System.out.println(list.stream().reduce("#", String::concat));

        /**
         * 3.parallelStream性能优于stream，通过并行Stream来提升性能
         */
        list.parallelStream().collect(Collectors.toSet());

        /**
         * 4.Stream转换为Collection
         */
        Stream stream = Stream.of("mm", "bb", "ccc", "dd", "ee");
        List newList = (List) stream.collect(Collectors.toList());
        Set newSet = (Set) stream.collect(Collectors.toSet());
        Map<String, Man> map = Stream.of(
                new Man("xxx", 10),
                new Man("yyy", 11),
                new Man("zzz", 12)
        ).collect(
                Collectors.toMap(Man::getName, man -> man, (oldValue, newValue) -> newValue)
        );


        /**
         * 5.Map不能直接转换为流
         */
        map.forEach((String key, Man val) -> {
            System.out.println(key);
            System.out.println(val);
        });
        System.out.println(map.getOrDefault("mmm", null));
        map.entrySet().stream();
        map.keySet().stream();
        map.values().stream();
    }
}