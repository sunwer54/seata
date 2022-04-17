package com.seata.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface StorageServiceApi {
    /**
     * 根据商品编码扣库存
     * @param code ：商品编码
     * @param count ：下单商品数量
     * @return
     */
    @GetMapping("/storage/{code}/{count}")
    public String deductStorage(@PathVariable("code") String code,@PathVariable("count") Integer count);
}
