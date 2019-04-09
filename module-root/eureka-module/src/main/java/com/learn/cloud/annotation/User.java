package com.learn.cloud.annotation;

import lombok.Data;

/**
 * 类名称:User
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/3/20 17:24
 * Version 1.0
 */
@Data
public class User implements Comparable {

    public String mName;
    public int mAge;

    @Override
    public String toString(){
       return mName + ":" + mAge;
    }

    @Override
    public int compareTo(Object o) {
        return ((User)o).mAge - this.mAge;
    }

    // this - o     升序
    // o - this     降序
}