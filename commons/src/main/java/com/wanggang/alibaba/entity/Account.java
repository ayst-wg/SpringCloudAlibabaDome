package com.wanggang.alibaba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName : Account
 * @Description : Account
 * @Author : wanggang
 * @Date: 2020-10-12 22:14
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private long id;

    private long userId;

    private double total;

    private double used;

    private double residue;

}
