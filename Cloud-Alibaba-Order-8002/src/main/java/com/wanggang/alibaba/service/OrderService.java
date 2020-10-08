package com.wanggang.alibaba.service;

import com.wanggang.alibaba.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : OrderService
 * @Description : OrderService
 * @Author : wanggang
 * @Date: 2020-10-06 01:10
 * @Version 1.0
 **/
public interface OrderService {
    public Order getOrderInfoById(@Param("id") long id);
}
