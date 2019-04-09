package com.learn.cloud.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * 类名称:BaseRepository
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/4/9 16:48
 * Version 1.0
 */
@NoRepositoryBean
public interface BaseRepository<T,I extends Serializable> extends
        PagingAndSortingRepository<T,I>,
        JpaSpecificationExecutor<T> {

}