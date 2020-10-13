package com.wanggang.alibaba.dao;

import com.wanggang.alibaba.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : StorageDao
 * @Description : StorageDao
 * @Author : wanggang
 * @Date: 2020-10-12 21:27
 * @Version 1.0
 **/
@Mapper
public interface StorageDao {

    public void createStorage(Storage storage);

    public void updateStorageNum(Storage storage);

    public Storage getStorageInfoById(@Param("id") long id);

}
