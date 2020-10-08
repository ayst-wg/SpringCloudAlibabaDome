package com.wanggang.alibaba.contorller;

import com.wanggang.alibaba.result.CommonResult;
import com.wanggang.alibaba.result.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : ConfigClientContorller
 * @Description : ConfigClientContorller
 * @Author : wanggang
 * @Date: 2020-10-06 19:10
 * @Version 1.0
 **/
@RestController
@Slf4j
@RefreshScope  // 支持nacos的动态刷新功能
public class ConfigClientContorller {

    @Value("${config.Info}")
    private String config;

    @GetMapping(value = "/nacos/getNacosConfigInfo")
    public CommonResult getNacosConfigInfo() {

        return new CommonResult(config, StatusCode.SUCCESS);
    }

}
