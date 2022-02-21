package com.cxw.service;

import com.cxw.service.impl.FeignHystrixServiceFallback;
import com.cxw.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "cloud-payment-provider-hystrix", fallback = FeignHystrixServiceFallback.class)
public interface FeignHystrixServiceClient {

    @GetMapping("/payments/ok/{id}")
    CommonResult<String> ok(@PathVariable("id") Long id);

    @GetMapping("/payments/notOk/{id}")
    CommonResult<String> notOk(@PathVariable("id") Long id);

}