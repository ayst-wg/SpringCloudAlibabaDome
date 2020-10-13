package com.wanggang.alibaba.contorller;

import com.wanggang.alibaba.entity.SeataOrder;
import com.wanggang.alibaba.result.CommonResult;
import com.wanggang.alibaba.result.StatusCode;
import com.wanggang.alibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName : OrderContorller
 * @Description : OrderContorller
 * @Author : wanggang
 * @Date: 2020-10-12 20:29
 * @Version 1.0
 **/
@RestController
@Slf4j
public class OrderContorller {

    @Resource
    private OrderService orderService;

    @GetMapping("/seata/createOrder")
    public CommonResult createOrder(){

        SeataOrder order = new SeataOrder();
        order.setOrderId(1);
        order.setUserId(1);
        order.setCount(1);
        order.setProductId(1);
        order.setPrice(21.5);
        order.setStatus(0);

        this.orderService.createOrder(order);

        return new CommonResult("订单信息保存成功", StatusCode.SUCCESS);

    }

    @GetMapping("/seata/getOrderInfoById")
    public CommonResult getOrderInfoById(@PathVariable("id") long id){

        SeataOrder order = this.orderService.getOrderInfoById(id);

        return new CommonResult("订单查询成功：" , StatusCode.SUCCESS);

    }

}
