package com.seata.business.service.impl;

import com.seata.business.service.AccountService;
import com.seata.business.service.BusinessService;
import com.seata.business.service.OrderService;
import com.seata.business.service.StorageService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {
    //注入本地化了的远程服务接口
    @Autowired
    private OrderService orderService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;
    @Override
    @GlobalTransactional //全局分布式事务注解（当前方法调用之后，的所有处理全部纳入同一个事务中）
    public String CreateBusiness(String userId, String code, int count, int money) {
        storageService.deductStorage(code, count);
        accountService.deductAccount(userId, money);
        orderService.createOrder(userId, code, count, money);
        //全局事务id
        String xid = RootContext.getXID();
        System.out.println("全局事务id="+xid);
        return "商品购买成功";
    }
}
