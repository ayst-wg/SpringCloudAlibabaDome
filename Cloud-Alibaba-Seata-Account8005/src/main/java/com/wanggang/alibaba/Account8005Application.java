package com.wanggang.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName : Account8005Application
 * @Description : Account8005Application
 * @Author : wanggang
 * @Date: 2020-10-12 23:01
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Account8005Application {
    public static void main(String[] args) {
        SpringApplication.run(Account8005Application.class,args);
    }
}
