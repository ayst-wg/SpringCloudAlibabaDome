package com.wanggang.alibaba.dao;

import com.wanggang.alibaba.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : OrderDao
 * @Description : OrderDao
 * @Author : wanggang
 * @Date: 2020-10-06 00:46
 * @Version 1.0
 **/
@Mapper
public interface OrderDao {
    public Order getOrderInfoById(@Param("id") long id);
}
