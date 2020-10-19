package com.wanggang.alibaba.service;

import com.wanggang.alibaba.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : RedisService
 * @Description : RedisService
 * @Author : wanggang
 * @Date: 2020-10-19 15:33
 * @Version 1.0
 **/
public interface RedisService {

    public int insert(User user);

    public int update(User user);

    public int delete(@Param("id") long id);

    public User getUserById(@Param("id") long id);

}
