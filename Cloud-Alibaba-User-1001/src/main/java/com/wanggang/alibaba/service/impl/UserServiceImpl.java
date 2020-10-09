package com.wanggang.alibaba.service.impl;

import com.wanggang.alibaba.dao.UserDao;
import com.wanggang.alibaba.entity.User;
import com.wanggang.alibaba.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName : UserServiceImpl
 * @Description : UserServiceImpl
 * @Author : wanggang
 * @Date: 2020-10-09 20:24
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserInfoById(long id) {
        return userDao.getUserInfoById(id);
    }

}
