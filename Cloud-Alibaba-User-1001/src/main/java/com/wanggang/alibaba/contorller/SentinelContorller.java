package com.wanggang.alibaba.contorller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wanggang.alibaba.entity.Order;
import com.wanggang.alibaba.entity.User;
import com.wanggang.alibaba.result.CommonResult;
import com.wanggang.alibaba.result.StatusCode;
import com.wanggang.alibaba.service.OrderFeginService;
import com.wanggang.alibaba.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName : SentinelContorller
 * @Description : SentinelContorller
 * @Author : wanggang
 * @Date: 2020-10-09 20:16
 * @Version 1.0
 **/
@RestController
@Slf4j
public class SentinelContorller {

    @Value("${service-url.nacos-order-service}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UserService userService;
    @Resource
    private OrderFeginService orderFeginService;

    @RequestMapping("/user/sentinel/fallback/{id}")
//    @SentinelResource(value = "fallback") // 没有配置
//    @SentinelResource(value = "fallback",fallback ="handlerFallback") // fallback只负责业务程序异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")   // blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", fallback ="handlerFallback", blockHandler = "blockHandler")  // 全部配置
    public CommonResult<Order> fallback(@PathVariable Long id) {

        CommonResult<Order> result = restTemplate.getForObject(serverUrl + "/order/getOrderInfoById/" + id,CommonResult.class,id);

        if(id <= 0){
            throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
        }else if(result.getResult() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return  result;
    }

    /**
        fallback：处理业务程序异常
     **/
    public CommonResult<User> handlerFallback(@PathVariable Long id,Throwable e) {
        return new CommonResult("程序发生异常handlerFallback，exception内容： " + e.getMessage(), StatusCode.FAIL);
    }

    /**
        blockHandler：处理sentinel控制台配置违规
     **/
    public CommonResult blockHandler(@PathVariable Long id, BlockException e) {
        return new CommonResult("blockHandler-sentinel控制台限流，BlockException： " + e.getMessage(), StatusCode.FAIL);
    }

    /**

     **/
    @GetMapping(value = "/user/sentinel/getOrderInfoById/{id}")
    public CommonResult< Order > getOrderInfoById(@PathVariable("id") Long id){
        return this.orderFeginService.getOrderInfoById(id);
    }
}
