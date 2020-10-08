package com.wanggang.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : ConfigClient3377Application
 * @Description : ConfigClient3377Application
 * @Author : wanggang
 * @Date: 2020-10-06 19:10
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClient3377Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3377Application.class,args);
    }
}
