package com.wanggang.alibaba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName : SeataOrder
 * @Description : SeataOrder
 * @Author : wanggang
 * @Date: 2020-10-12 20:50
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeataOrder implements Serializable {

    private long id;

    private long userId;

    private long orderId;

    private long productId;

    private int count;

    private double price;

    private int status;


}
