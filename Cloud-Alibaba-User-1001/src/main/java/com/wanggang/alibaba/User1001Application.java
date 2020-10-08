package com.wanggang.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : User1001Application
 * @Description : User1001Application
 * @Author : wanggang
 * @Date: 2020-10-06 01:45
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class User1001Application {
    public static void main(String[] args) {
        SpringApplication.run(User1001Application.class,args);
    }
}
