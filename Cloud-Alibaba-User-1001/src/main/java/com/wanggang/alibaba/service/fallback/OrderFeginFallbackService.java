package com.wanggang.alibaba.service.fallback;

import com.wanggang.alibaba.result.CommonResult;
import com.wanggang.alibaba.result.StatusCode;
import com.wanggang.alibaba.service.OrderFeginService;
import org.springframework.stereotype.Component;

/**
 * @ClassName : OrderFeginServiceImpl
 * @Description : OrderFeginServiceImpl
 * @Author : wanggang
 * @Date: 2020-10-09 20:53
 * @Version 1.0
 **/
@Component
public class OrderFeginFallbackService implements OrderFeginService {

    @Override
    public CommonResult getOrderInfoById(long id) {
        return new CommonResult("服务降级返回处理：OrderFeginFallbackService", StatusCode.FAIL);
    }
}
