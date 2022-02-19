package com.cxw.springcloud.controller;

import com.cxw.springcloud.entity.CommonResult;
import com.cxw.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName OrderController
 * @Author xuwen_chen
 * @Date 2022-02-17 23:12
 * @Version 1.0
 */

@RestController
@RequestMapping("consumer")
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    /**这里服务名直接写死了，后面还需要优化**/
    private String serverName = "http://cloud-payment-sevice8004";

    @GetMapping("zk/{id}")
    @ResponseBody
    public CommonResult<Payment> getById(@PathVariable Long id) {
        String providerUrl = serverName + "/payments/zk/";
        return restTemplate.getForObject(providerUrl + id, CommonResult.class);
    }

}
