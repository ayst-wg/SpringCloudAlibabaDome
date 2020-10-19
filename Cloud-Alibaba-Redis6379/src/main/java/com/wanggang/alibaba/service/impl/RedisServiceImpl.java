package com.wanggang.alibaba.service.impl;

import com.wanggang.alibaba.dao.RedisDao;
import com.wanggang.alibaba.entity.User;
import com.wanggang.alibaba.service.RedisService;
import com.wanggang.alibaba.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName : RedisServiceImpl
 * @Description : RedisServiceImpl
 * @Author : wanggang
 * @Date: 2020-10-19 18:00
 * @Version 1.0
 **/
@Service
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisDao redisDao;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public int insert(User user) {
        String key = "user_";
        int result = this.redisDao.insert(user);
        log.info("从数据库中插入数据：" + user);
        if (result != 0) {
            User user_db = this.redisDao.getUserSortId(user);
            this.redisUtil.set(key + user_db.getId(), user_db);
            log.info("从Redis缓存中添加数据：" + user);
            log.info("读取Redis缓存：" + redisUtil.get(key+user_db.getId()).toString());
        }
        return result;
    }

    @Override
    public int update(User user) {
        String key = "user_" + user.getId();
        int result = this.redisDao.update(user);
        log.info("从数据库中修改数据：user：" + user);
        if (result != 0) {
            this.redisUtil.del(key);
            log.info("从Redis缓存中删除修改前数据：key：" + key);
            this.redisUtil.set(key, user);
            log.info("从Redis缓存中添加修改后数据：key：" + key);
            log.info("读取Redis缓存：" + redisUtil.get(key).toString());
        }
        return result;
    }

    @Override
    public int delete(long id) {
        String key = "user_" + id;
        int result = this.redisDao.delete(id);
        if (result != 0) {
            log.info("从数据库中删除数据：id：" + id);
            this.redisUtil.del(key);
            log.info("从Redis缓存中删除数据：key：" + key);
            log.info("Redis缓存：" + key + "：" + redisUtil.hasKey(key));
        }else {
            this.redisUtil.del(key);
            log.info("数据库中没有id为：" + id + " 的记录，删除失败！");
        }
        return result;
    }

    @Override
    public User getUserById(long id) {
        String key = "user_" + id;
        User user = null;
        boolean hasKey = redisUtil.hasKey(key);
        if (hasKey) {
            user = (User) redisUtil.get(key);
            log.info("从Redis缓存中获得数据：user：" + user);
        } else {
            user = this.redisDao.getUserById(id);
            log.info("查询数据库获得数据：" + user);
            if (user != null) {
                redisUtil.set(key, user);
                log.info(key + " 已成功写入redis缓存");
                log.info("读取Redis缓存：" + redisUtil.get(key).toString());
            } else {
                log.info("数据库中没有id为：" + id + " 的用户信息");
            }
        }
        return user;
    }
}
