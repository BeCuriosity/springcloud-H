package com.cxw.controller;

import com.cxw.service.FeignServiceClient;
import com.cxw.springcloud.entity.CommonResult;
import com.cxw.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {

    @Resource
    private FeignServiceClient feignServiceClient;

    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<Payment> getById(@PathVariable Long id) {
        return feignServiceClient.getById(id);
    }

}