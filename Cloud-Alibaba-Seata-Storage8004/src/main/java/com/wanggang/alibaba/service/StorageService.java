package com.wanggang.alibaba.service;

import com.wanggang.alibaba.entity.Storage;

/**
 * @ClassName : StorageService
 * @Description : StorageService
 * @Author : wanggang
 * @Date: 2020-10-12 21:27
 * @Version 1.0
 **/
public interface StorageService {

    public void createStorage(Storage storage);

    public void updateStorageNum(Storage storage);

    public Storage getStorageInfoById(long id);
}
