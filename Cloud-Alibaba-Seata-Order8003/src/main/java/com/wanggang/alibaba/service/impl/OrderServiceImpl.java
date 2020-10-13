package com.wanggang.alibaba.service.impl;

import com.wanggang.alibaba.dao.OrderDao;
import com.wanggang.alibaba.entity.SeataOrder;
import com.wanggang.alibaba.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName : OrderServiceImpl
 * @Description : OrderServiceImpl
 * @Author : wanggang
 * @Date: 2020-10-12 20:30
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public void createOrder(SeataOrder order) {
        this.orderDao.createOrder(order);
    }

    @Override
    public SeataOrder getOrderInfoById(long id) {
        return this.orderDao.getOrderInfoById(id);
    }
}
