package com.wanggang.alibaba;

import com.wanggang.alibaba.config.DataSourceProxyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName : SeataOrder8003Application
 * @Description : SeataOrder8003Application
 * @Author : wanggang
 * @Date: 2020-10-12 20:27
 * @Version 1.0
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceProxyConfig.class)
public class SeataOrder8003Application {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrder8003Application.class,args);
    }
}
