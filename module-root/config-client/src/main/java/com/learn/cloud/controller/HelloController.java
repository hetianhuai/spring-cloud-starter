package com.learn.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称:HelloController
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/3/18 10:21
 * Version 1.0
 *      当有请求/fresh节点的时候，会重新请求一次ConfigServer去拉取最新的配置文件
 *      请求/fresh需要有几点要求：1.加actuator的依赖 2.SpringCloud1.5以上需要设置 management.security.enabled=false
 */
@RestController
@RefreshScope // 开启更新功能,使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
class HelloController {

    @Value("${neo.hello}")
    private String hello;

    @RequestMapping("/hello")
    @ResponseBody
    public String from() {
        return this.hello;
    }
}