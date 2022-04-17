package com.seata.business;

import com.seata.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {
    //注入本地接口服务
    @Autowired
    private BusinessService businessService;
    @RequestMapping("/business/{userId}/{code}/{count}/{money}")
    public String CreateBusiness(@PathVariable String userId, @PathVariable String code,@PathVariable int count,@PathVariable int money){
        return businessService.CreateBusiness(userId, code, count, money);
    }
}
