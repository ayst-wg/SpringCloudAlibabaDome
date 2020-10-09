package com.wanggang.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wanggang.alibaba.result.CommonResult;
import com.wanggang.alibaba.result.StatusCode;

/**
 * @ClassName : CustomerBlockHandler
 * @Description : CustomerBlockHandler
 * @Author : wanggang
 * @Date: 2020-10-09 17:53
 * @Version 1.0
 **/
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult("自定义处理方法：handlerException1",StatusCode.FAIL);
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult("自定义处理方法：handlerException2",StatusCode.FAIL);
    }
}
