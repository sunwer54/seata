package com.seata.account.service.impl;

import com.seata.mapper.AccountMapper;
import com.seata.pojo.Account;
import com.seata.pojo.AccountExample;
import com.seata.account.service.AccountService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    //注入Mapper
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public int deductAccount(String userId, Integer money) {
        //先检查是否有该用户
        AccountExample exp = new AccountExample();
        exp.createCriteria().andUserIdEqualTo(userId);
        List<Account> accounts = accountMapper.selectByExample(exp);
        if (accounts==null||accounts.size()==0){
            throw new IllegalArgumentException("用户不存在");
        }
        //用户存在时，判断账户余额是否足够
        Account account = accounts.get(0);
        int m = account.getMoney()-money;
        if (m<0){
            throw new IllegalArgumentException("账户余额不足");
        }
        //余额足够时，执行账户余额扣减
        account.setMoney(m);
        String xid = RootContext.getXID();
        System.out.println("全局事务id"+xid);
        return accountMapper.updateByExampleSelective(account,exp);
    }
}
