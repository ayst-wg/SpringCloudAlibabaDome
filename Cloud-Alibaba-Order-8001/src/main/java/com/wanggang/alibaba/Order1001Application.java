package com.wanggang.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : Order1001Application
 * @Description : Order1001Application
 * @Author : wanggang
 * @Date: 2020-10-06 00:26
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class Order1001Application {
    public static void main(String[] args) {
        SpringApplication.run(Order1001Application.class,args);
    }
}
