package com.seata.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface OrderServiceApi {
    /**
     * 创建订单
     * @param userId ：用户id
     * @param code :商品编码
     * @param count ：下单数量
     * @param money ：下单金额
     * @return
     */
    @GetMapping("/order/{userId}/{code}/{count}/{money}")
    public String createOrder(@PathVariable("userId") String userId,@PathVariable("code") String code, @PathVariable("count") Integer count,@PathVariable("money") Integer money);
}
