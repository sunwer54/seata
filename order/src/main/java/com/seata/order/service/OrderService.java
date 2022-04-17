package com.seata.order.service;

public interface OrderService {
    public int createOrder(String userId, String code, Integer count, Integer money);
}
