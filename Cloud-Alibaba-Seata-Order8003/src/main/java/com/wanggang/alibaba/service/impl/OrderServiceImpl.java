package com.wanggang.alibaba.service.impl;

import com.wanggang.alibaba.dao.OrderSeataDao;
import com.wanggang.alibaba.entity.SeataOrder;
import com.wanggang.alibaba.service.AccountService;
import com.wanggang.alibaba.service.OrderService;
import com.wanggang.alibaba.service.StorageService;
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
    private OrderSeataDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "SEATA_GROUP", rollbackFor = Exception.class)
    public void createOrder(SeataOrder order) {
        log.info("创建订单。。。。。");
        this.orderDao.createOrder(order);

        log.info("扣减库存。。。。。。");
        storageService.updateStorageNum(1);

        log.info("扣减账户额度。。。。。。");
        accountService.updateAccountPrice(1);

        log.info("修改订单状态。。。。。。");
        this.orderDao.updateOrderStatus(order.getId(),1);
    }

    @Override
    public void updateOrderStatus(long id, int status) {
        this.orderDao.updateOrderStatus(id,status);
    }

    @Override
    public SeataOrder getOrderInfoById(long id) {
        return this.orderDao.getOrderInfoById(id);
    }
}
