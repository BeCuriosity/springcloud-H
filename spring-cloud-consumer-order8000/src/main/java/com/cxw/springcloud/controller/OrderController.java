package com.cxw.springcloud.controller;

import com.cxw.springcloud.entity.CommonResult;
import com.cxw.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Author xuwen_chen
 * @Date 2022-02-17 23:12
 * @Version 1.0
 */

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<Payment> getById(@PathVariable Long id) {
        String providerUrl = "http://127.0.0.1:8001/payments/";
        return restTemplate.getForObject(providerUrl + id, CommonResult.class);
    }
}
