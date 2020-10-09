package com.wanggang.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : Sentinel8401Application
 * @Description : Sentinel8401Application
 * @Author : wanggang
 * @Date: 2020-10-08 18:59
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class Sentinel8401Application {
    public static void main(String[] args) {
        SpringApplication.run(Sentinel8401Application.class,args);
    }
}
