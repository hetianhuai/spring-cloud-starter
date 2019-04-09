package com.learn.cloud.service;

import com.learn.cloud.dao.RoleRepository;
import com.learn.cloud.dao.UserRepository;
import com.learn.cloud.po.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名称:Service
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/4/9 16:25
 * Version 1.0
 */
public class Service {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public User findUserByName(String username) {
        return userRepository.findByName(username);
    }
}