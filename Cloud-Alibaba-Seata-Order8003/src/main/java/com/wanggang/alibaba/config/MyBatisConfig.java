package com.wanggang.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @ClassName : MyBatisConfig
 * @Description : MyBatisConfig
 * @Author : wanggang
 * @Date: 2020-10-13 15:03
 * @Version 1.0
 **/
@Configurable
@MapperScan({"com.wanggang.alibaba.dao"})
public class MyBatisConfig {

}
