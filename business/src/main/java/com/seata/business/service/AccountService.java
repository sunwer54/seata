package com.seata.business.service;

import com.seata.api.AccountServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("account-service")
public interface AccountService extends AccountServiceApi {
}
