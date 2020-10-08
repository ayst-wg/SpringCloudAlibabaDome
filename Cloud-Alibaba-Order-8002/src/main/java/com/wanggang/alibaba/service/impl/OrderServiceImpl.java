package com.wanggang.alibaba.service.impl;

import com.wanggang.alibaba.dao.OrderDao;
import com.wanggang.alibaba.entity.Order;
import com.wanggang.alibaba.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName : OrderServiceImpl
 * @Description : OrderServiceImpl
 * @Author : wanggang
 * @Date: 2020-10-06 01:13
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public Order getOrderInfoById(long id) {
        return orderDao.getOrderInfoById(id);
    }
}
