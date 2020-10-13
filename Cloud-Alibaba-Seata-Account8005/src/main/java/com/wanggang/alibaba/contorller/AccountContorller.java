package com.wanggang.alibaba.contorller;

import com.wanggang.alibaba.entity.Account;
import com.wanggang.alibaba.result.CommonResult;
import com.wanggang.alibaba.result.StatusCode;
import com.wanggang.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName : AccountContorller
 * @Description : AccountContorller
 * @Author : wanggang
 * @Date: 2020-10-12 23:09
 * @Version 1.0
 **/
@RestController
@Slf4j
public class AccountContorller {

    @Resource
    private AccountService accountService;

    @GetMapping("/seate/account/updateAccountPrice")
    public CommonResult updateAccountPrice(@PathVariable("id") long id) {
        Account account = this.accountService.getAccountInfoById(id);
        if(account != null){
            double num = 12.2;
            account.setTotal(account.getTotal() - num);
            account.setUsed(account.getUsed() + num);
            account.setResidue(account.getResidue() - num);
            this.accountService.updateAccountPrice(account);
            return new CommonResult("", StatusCode.SUCCESS);
        }
        return new CommonResult("没有ID为：" + id + " 的账户记录！", StatusCode.FAIL);
    }

}
