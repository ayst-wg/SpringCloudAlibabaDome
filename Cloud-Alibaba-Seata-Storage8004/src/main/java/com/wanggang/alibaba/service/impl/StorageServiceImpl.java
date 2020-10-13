package com.wanggang.alibaba.service.impl;

import com.wanggang.alibaba.dao.StorageDao;
import com.wanggang.alibaba.entity.Storage;
import com.wanggang.alibaba.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName : StorageServiceImpl
 * @Description : StorageServiceImpl
 * @Author : wanggang
 * @Date: 2020-10-12 21:28
 * @Version 1.0
 **/
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void createStorage(Storage storage) {
        this.storageDao.createStorage(storage);
    }

    @Override
    public void updateStorageNum(Storage storage) {
        this.storageDao.updateStorageNum(storage);
    }

    @Override
    public Storage getStorageInfoById(long id) {
        return this.storageDao.getStorageInfoById(id);
    }
}
