package com.wanggang.alibaba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName : User
 * @Description :
 * @Author : wanggang
 * @Date: 2020-09-24 19:09
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private long id;

    private String username;

    private int age;

    private String address;

}
