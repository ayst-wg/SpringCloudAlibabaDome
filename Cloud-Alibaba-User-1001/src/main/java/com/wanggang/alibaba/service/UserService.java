package com.wanggang.alibaba.service;

import com.wanggang.alibaba.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : UserService
 * @Description : UserService
 * @Author : wanggang
 * @Date: 2020-10-09 20:23
 * @Version 1.0
 **/
public interface UserService {

    public User getUserInfoById(@Param("id") long id);

}
