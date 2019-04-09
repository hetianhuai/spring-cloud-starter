package com.learn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 类名称:ShiroModuleApplication
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/4/9 16:06
 * Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ShiroModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroModuleApplication.class, args);
    }
}