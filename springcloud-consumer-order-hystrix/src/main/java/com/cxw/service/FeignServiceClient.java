package com.cxw.service;

import com.cxw.springcloud.entity.CommonResult;
import com.cxw.springcloud.entity.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("cloud-payment-provider-hystrix")
@RequestMapping("/")
public interface FeignServiceClient {

    @GetMapping("/payments/ok/{id}")
    CommonResult<String> ok(@PathVariable("id") Long id);

    @GetMapping("/payments/notOk/{id}")
    CommonResult<String> notOk(@PathVariable("id") Long id);

}