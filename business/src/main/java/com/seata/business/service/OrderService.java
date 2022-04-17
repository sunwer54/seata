package com.seata.business.service;

import com.seata.api.OrderServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("order-service")
public interface OrderService extends OrderServiceApi {
}
