package com.wanggang.alibaba.contorller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import com.wanggang.alibaba.entity.User;
import com.wanggang.alibaba.result.CommonResult;
import com.wanggang.alibaba.result.StatusCode;
import com.wanggang.alibaba.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Scanner;

/**
 * @ClassName : RedisContorller
 * @Description : RedisContorller
 * @Author : Administrator
 * @Date: 2020-10-18 23:00
 * @Version 1.0
 **/
@RestController
@Slf4j
public class RedisContorller extends BaseContorller {

    @Resource
    private RedisService redisService;

    @GetMapping("/redis/optRedis")
    public CommonResult optRedis(@RequestParam("opt") String opt, @RequestParam("id") long id) {
        if (opt.isEmpty())
            return new CommonResult("opt参数不能为空！", StatusCode.REQUEST_PARAM_ERROR);
        if (!opt.equals("insert")) {
            if (id <= 0)
                return new CommonResult("id参数不能为空！且必须是正整数", StatusCode.REQUEST_PARAM_ERROR);
        }
        User user = null;
        int result = 0;
        switch (opt) {
            case "insert":
                user = new User();
                user.setUsername("redis_" + NumberUtil.generateRandomNumber(1, 99, 2)[0]);
                user.setAge(NumberUtil.generateRandomNumber(18, 60, 2)[0]);
                user.setAddress(IdUtil.randomUUID());
                result = this.redisService.insert(user);
                if (result != 0)
                    return new CommonResult("用户添加成功：" + user, StatusCode.SUCCESS);
                return new CommonResult("用户添加失败！", StatusCode.FAIL);
            case "update":
                user = this.redisService.getUserById(id);
                Scanner input = new Scanner(System.in);
                String username = input.next();
                int age = input.nextInt();
                String address = input.next();
                user.setUsername(username);
                user.setAge(age);
                user.setAddress(address);
                result = this.redisService.update(user);
                if (result != 0)
                    return new CommonResult("用户 " + id + " 修改成功！" + user, StatusCode.SUCCESS);
                return new CommonResult("没有用户id为：" + id + " 的用户记录，修改失败！", StatusCode.FAIL);
            case "delete":
                result = this.redisService.delete(id);
                if (result != 0)
                    return new CommonResult("用户 " + id + " 删除成功！", StatusCode.SUCCESS);
                return new CommonResult("没有用户id为：" + id + " 的用户记录，删除失败！", StatusCode.FAIL);
            case "select":
                user = this.redisService.getUserById(id);
                if (user != null) {
                    return new CommonResult("用户" + id + "查询成功：" + user, StatusCode.SUCCESS);
                }
                return new CommonResult("没有用户id为："+id+" 的记录！", StatusCode.FAIL);
        }
        return new CommonResult("没有opt为：" + opt + " 的操作，执行失败！", StatusCode.FAIL);
    }

}
