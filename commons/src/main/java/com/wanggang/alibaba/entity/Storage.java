package com.wanggang.alibaba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName : Storage
 * @Description : Storage
 * @Author : wanggang
 * @Date: 2020-10-12 22:11
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage implements Serializable {

    private long id;

    private long productId;

    private int total;

    private int used;

    private int residue;

}
