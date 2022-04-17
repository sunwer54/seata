package com.seata.storage;

import com.seata.api.StorageServiceApi;
import com.seata.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController implements StorageServiceApi {
    @Autowired
    private StorageService storageService;
    @Override
    public String deductStorage(String code, Integer count) {
        int n = storageService.deductStorage(code, count);
        if (n==1) {
            return "库存扣减成功";
        }
        return "库存扣减失败";
    }
}
