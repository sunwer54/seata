package com.seata.storage.service.impl;

import com.seata.mapper.StorageMapper;
import com.seata.pojo.Storage;
import com.seata.pojo.StorageExample;
import com.seata.storage.service.StorageService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;
    @Override
    public int deductStorage(String code, Integer count) {
        //先检查是否有该商品
        StorageExample exp = new StorageExample();
        exp.createCriteria().andCommodityCodeEqualTo(code);
        List<Storage> storages = storageMapper.selectByExample(exp);
        if (storages==null||storages.size()==0){
            throw new IllegalArgumentException("商品不存在");
        }
        //商品存在时，判断库存是否足够
        Storage storage = storages.get(0);
        int m = storage.getCount()- count;
        if (m<0){
            throw new IllegalArgumentException("商品库存不足");
        }
        //库存足够时，执行扣库存
        storage.setCount(m);
        String xid = RootContext.getXID();
        System.out.println("全局事务id="+xid);
        return storageMapper.updateByPrimaryKeySelective(storage);
    }
}
