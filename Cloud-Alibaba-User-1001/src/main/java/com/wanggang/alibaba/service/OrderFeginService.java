package com.wanggang.alibaba.service;

import com.wanggang.alibaba.entity.Order;
import com.wanggang.alibaba.result.CommonResult;
import com.wanggang.alibaba.service.fallback.OrderFeginFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName : OrderServiceFegin
 * @Description : OrderServiceFegin
 * @Author : wanggang
 * @Date: 2020-10-09 20:48
 * @Version 1.0
 **/
@FeignClient(value = "cloudalibaba-order-service", fallback = OrderFeginFallbackService.class)
public interface OrderFeginService {

    @GetMapping("/order/getOrderInfoById/{id}")
    public CommonResult<Order> getOrderInfoById(@PathVariable("id") long id);

}
