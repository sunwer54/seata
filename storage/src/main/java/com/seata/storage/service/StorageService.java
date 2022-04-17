package com.seata.storage.service;

public interface StorageService {
    /**
     * 根据商品编码扣库存
     * @param code ：商品编码
     * @param count ：下单商品数量
     * @return
     */
    public int deductStorage(String code, Integer count);
}
