package com.cxw.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName StorageService
 * @Author xuwen_chen
 * @Date 2022-03-01 23:24
 * @Version 1.0
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 使用feign调用减少库存
     * @param productId
     * @param count
     */
    @PostMapping(value = "/storage/decrease")
    void decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
