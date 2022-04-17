package com.seata.account.service;

public interface AccountService {
    public int deductAccount(String userId, Integer money);
}
