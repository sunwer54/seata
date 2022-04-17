package com.seata.order;

import com.seata.api.OrderServiceApi;
import com.seata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderServiceApi {
    @Autowired
    private OrderService orderService;
    @Override
    public String createOrder(String userId, String code, Integer count, Integer money) {
        int n = orderService.createOrder(userId, code, count, money);
        if (n==1){
            return "订单创建成功";
        }
        return "失败";
    }
}
