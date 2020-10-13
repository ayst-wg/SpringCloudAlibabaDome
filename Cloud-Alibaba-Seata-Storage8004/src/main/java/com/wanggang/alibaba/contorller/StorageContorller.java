package com.wanggang.alibaba.contorller;

import com.wanggang.alibaba.entity.Storage;
import com.wanggang.alibaba.result.CommonResult;
import com.wanggang.alibaba.result.StatusCode;
import com.wanggang.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName : StorageContorller
 * @Description : StorageContorller
 * @Author : wanggang
 * @Date: 2020-10-12 21:28
 * @Version 1.0
 **/
@RestController
@Slf4j
public class StorageContorller {

    @Resource
    private StorageService storageService;

    @GetMapping("/seata/setStorageNum/{id}")
    public CommonResult setStorageNum(@PathVariable("id") long id){
        Storage storage = this.storageService.getStorageInfoById(id);
        if(storage != null){
            int num = 2;
            storage.setTotal(storage.getTotal() - num);
            storage.setUsed(storage.getUsed() + num);
            storage.setResidue(storage.getResidue() - num);
            this.storageService.updateStorageNum(storage);
            return new CommonResult("已经成功扣减库存： " + num, StatusCode.SUCCESS);
        }else {
            return new CommonResult("没有ID为：" + id + " 的库存记录！", StatusCode.FAIL);
        }
    }

}
