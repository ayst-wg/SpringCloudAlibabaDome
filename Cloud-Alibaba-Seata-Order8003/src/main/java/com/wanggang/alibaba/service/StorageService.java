package com.wanggang.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName : StorageService
 * @Description : StorageService
 * @Author : Administrator
 * @Date: 2020-10-13 19:03
 * @Version 1.0
 **/
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @GetMapping("/storage/updateStorageNum/{id}")
    public void updateStorageNum(@PathVariable("id") long id);

}
