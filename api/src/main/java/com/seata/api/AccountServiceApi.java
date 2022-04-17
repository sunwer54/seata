package com.seata.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface AccountServiceApi {
    /**
     * 根据用户id扣减账户金额
     * @param userId ：用户id
     * @param money ：下单金额
     * @return
     */
    @GetMapping("/account/{userId}/{money}")
    public String deductAccount(@PathVariable("userId") String userId,@PathVariable("money") Integer money);
}
