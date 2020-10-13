package com.wanggang.alibaba.service;

import com.wanggang.alibaba.entity.SeataOrder;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : OrderService
 * @Description : OrderService
 * @Author : wanggang
 * @Date: 2020-10-12 20:29
 * @Version 1.0
 **/
public interface OrderService {

    public void createOrder(SeataOrder order);

    public void updateOrderStatus(@Param("id") long id, @Param("status") int status);

    public SeataOrder getOrderInfoById(long id);

}
