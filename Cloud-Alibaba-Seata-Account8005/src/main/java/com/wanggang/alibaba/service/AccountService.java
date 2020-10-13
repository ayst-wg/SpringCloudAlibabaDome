package com.wanggang.alibaba.service;

import com.wanggang.alibaba.entity.Account;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : AccountService
 * @Description : AccountService
 * @Author : wanggang
 * @Date: 2020-10-12 23:08
 * @Version 1.0
 **/
public interface AccountService {

    public void createAccount(Account account);

    public void updateAccountPrice(Account account);

    public Account getAccountInfoById(@Param("id") long id);


}
