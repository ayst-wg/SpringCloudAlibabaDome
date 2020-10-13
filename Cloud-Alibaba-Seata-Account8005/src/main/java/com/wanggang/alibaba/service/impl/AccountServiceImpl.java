package com.wanggang.alibaba.service.impl;

import com.wanggang.alibaba.dao.AccountDao;
import com.wanggang.alibaba.entity.Account;
import com.wanggang.alibaba.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName : AccountServiceImpl
 * @Description : AccountServiceImpl
 * @Author : wanggang
 * @Date: 2020-10-12 23:08
 * @Version 1.0
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void createAccount(Account account) {
        this.accountDao.createAccount(account);
    }

    @Override
    public void updateAccountPrice(Account account) {
        this.accountDao.updateAccountPrice(account);
    }

    @Override
    public Account getAccountInfoById(long id) {
        return this.accountDao.getAccountInfoById(id);
    }
}
