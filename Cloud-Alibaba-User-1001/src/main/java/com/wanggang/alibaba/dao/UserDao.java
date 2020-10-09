package com.wanggang.alibaba.dao;

import com.wanggang.alibaba.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : UserDao
 * @Description : UserDao
 * @Author : wanggang
 * @Date: 2020-10-09 20:22
 * @Version 1.0
 **/
@Mapper
public interface UserDao {

    public User getUserInfoById(@Param("id") long id);

}
