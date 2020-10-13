package com.wanggang.alibaba.dao;

import com.wanggang.alibaba.entity.SeataOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : OrderDao
 * @Description : OrderDao
 * @Author : wanggang
 * @Date: 2020-10-12 20:29
 * @Version 1.0
 **/
@Mapper
public interface OrderSeataDao {

    public void createOrder(SeataOrder order);

    public void updateOrderStatus(@Param("id") long id, @Param("status") int status);

    public SeataOrder getOrderInfoById(@Param("id") long id);

}

