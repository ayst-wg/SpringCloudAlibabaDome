package com.wanggang.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName : AccountService
 * @Description : AccountService
 * @Author : Administrator
 * @Date: 2020-10-13 19:03
 * @Version 1.0
 **/
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @GetMapping("/account/updateAccountPrice/{id}")
    public void updateAccountPrice(@PathVariable("id") long id);

}
