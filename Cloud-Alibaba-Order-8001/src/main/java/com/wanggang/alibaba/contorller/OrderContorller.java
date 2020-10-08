package com.wanggang.alibaba.contorller;

import com.wanggang.alibaba.entity.Order;
import com.wanggang.alibaba.result.CommonResult;
import com.wanggang.alibaba.result.StatusCode;
import com.wanggang.alibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName : OrderContorller
 * @Description : OrderContorller
 * @Author : wanggang
 * @Date: 2020-10-06 00:33
 * @Version 1.0
 **/
@RestController
@Slf4j
public class OrderContorller {

    @Value("${server.port}")
    private String port;

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/order/getOrderInfoById/{id}")
    public CommonResult<Order> getOrderInfoById(@PathVariable("id") long id){
        Order order = orderService.getOrderInfoById(id);
        log.info("port：" + port + "\t result：" + order);
        return new CommonResult(order,StatusCode.SUCCESS);
    }
}
