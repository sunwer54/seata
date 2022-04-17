package com.seata.business.service;

import com.seata.api.StorageServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("storage-service")
public interface StorageService extends StorageServiceApi {
}
