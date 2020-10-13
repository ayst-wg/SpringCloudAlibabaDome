package com.wanggang.alibaba.service.impl;

import com.sun.media.jfxmedia.logging.Logger;
import com.wanggang.alibaba.dao.OrderDao;
import com.wanggang.alibaba.entity.SeataOrder;
import com.wanggang.alibaba.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    @GlobalTransactional(name = "SEATA_GROUP", rollbackFor = Exception.class)
    public void createOrder(SeataOrder order) {
        log.info("");
        this.orderDao.createOrder(order);
    }

    @Override
    public SeataOrder getOrderInfoById(long id) {
        return this.orderDao.getOrderInfoById(id);
    }
}
