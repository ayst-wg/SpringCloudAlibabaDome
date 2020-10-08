package com.wanggang.alibaba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName : Order
 * @Description :
 * @Author : wanggang
 * @Date: 2020-09-21 17:19
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private long id;

    private String orderId;

    private long uid;
}
