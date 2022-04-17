package com.seata.account;

import com.seata.api.AccountServiceApi;
import com.seata.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements AccountServiceApi {
    @Autowired
    private AccountService accountService;
    @Override
    public String deductAccount(String userId, Integer money) {
        int n = accountService.deductAccount(userId, money);
        if (n==1) {
            return "余额扣减成功";
        }
        return "余额扣减失败";
    }
}
