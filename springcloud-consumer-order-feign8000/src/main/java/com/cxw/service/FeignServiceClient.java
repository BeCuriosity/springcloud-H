package com.cxw.service;

import com.cxw.springcloud.entity.CommonResult;
import com.cxw.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName FeignServiceClient
 * @Author xuwen_chen
 * @Date 2022-02-20 18:40
 * @Version 1.0
 */
@FeignClient("cloud-payment-service")
@RequestMapping("/")
public interface FeignServiceClient {


    @GetMapping("/payments/{id}")
    CommonResult<Payment> getById(@PathVariable("id") Long id);
}
