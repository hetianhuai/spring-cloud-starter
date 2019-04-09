package com.learn.cloud.dao;

import com.learn.cloud.po.User;

/**
 * 类名称:UserRepository
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/4/9 16:49
 * Version 1.0
 */
public interface UserRepository extends BaseRepository<User,Long>{
    User findByName(String name);
}