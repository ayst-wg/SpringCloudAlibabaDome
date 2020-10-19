package com.wanggang.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : RedisApplication
 * @Description : RedisApplication
 * @Author : Administrator
 * @Date: 2020-10-18 23:01
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class Redis6379Application {
    public static void main(String[] args) {
        SpringApplication.run(Redis6379Application.class,args);
    }
}
