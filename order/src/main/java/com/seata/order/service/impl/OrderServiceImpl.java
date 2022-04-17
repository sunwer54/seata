package com.seata.order.service.impl;

import com.seata.mapper.TradeOrderMapper;
import com.seata.order.service.OrderService;
import com.seata.pojo.TradeOrder;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private TradeOrderMapper tradeOrderMapper;
    @Override
    public int createOrder(String userId, String code, Integer count, Integer money) {
        TradeOrder order = new TradeOrder();
        order.setUserId(userId);
        order.setCommodityCode(code);
        order.setCount(count);
        order.setMoney(money);
        String xid = RootContext.getXID();
        System.out.println("全局事务id"+xid);
        //模拟异常
        if ("USER".equals(userId)){
            throw new RuntimeException("创建订单异常");
        }
        return tradeOrderMapper.insert(order);
    }
}
