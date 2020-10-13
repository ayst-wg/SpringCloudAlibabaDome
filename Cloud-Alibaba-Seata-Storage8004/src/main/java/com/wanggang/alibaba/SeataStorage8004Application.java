package com.wanggang.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName : SeataStorage8004Application
 * @Description : SeataStorage8004Application
 * @Author : wanggang
 * @Date: 2020-10-12 21:26
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStorage8004Application {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorage8004Application.class,args);
    }
}
