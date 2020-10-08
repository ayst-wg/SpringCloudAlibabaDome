package com.wanggang.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : Order8002Application
 * @Description : Order8002Application
 * @Author : wanggang
 * @Date: 2020-10-06 01:11
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class Order8002Application {
    public static void main(String[] args) {
        SpringApplication.run(Order8002Application.class,args);
    }
}
