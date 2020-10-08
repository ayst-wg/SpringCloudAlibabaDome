package com.wanggang.alibaba.contorller;

import com.wanggang.alibaba.result.CommonResult;
import com.wanggang.alibaba.result.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName : UserContorller
 * @Description : UserContorller
 * @Author : wanggang
 * @Date: 2020-10-06 01:20
 * @Version 1.0
 **/
@RestController
@Slf4j
public class UserContorller {

    @Value("${service-url.nacos-order-service}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/user/getOrderByIdToOrder/{id}")
    public CommonResult<String> getOrderByIdToOrder(@PathVariable("id") long id){
        String str = serverUrl + "/order/getOrderInfoById/" +id;
        log.info(str);
        ResponseEntity<String> entity = restTemplate.getForEntity(str, String.class);
        return new CommonResult<String>(entity.getBody(),StatusCode.SUCCESS);
    }

}
