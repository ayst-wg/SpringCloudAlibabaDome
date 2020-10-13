package com.wanggang.alibaba.dao;

import com.wanggang.alibaba.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : AccountDao
 * @Description : AccountDao
 * @Author : wanggang
 * @Date: 2020-10-12 23:08
 * @Version 1.0
 **/
@Mapper
public interface AccountDao {

    public void createAccount(Account account);

    public void updateAccountPrice(Account account);

    public Account getAccountInfoById(@Param("id") long id);

}
