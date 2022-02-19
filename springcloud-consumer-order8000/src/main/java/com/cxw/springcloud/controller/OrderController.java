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
@Slf4j
@RequestMapping("consumer")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    /**这里服务名直接写死了，后面还需要优化**/
    private String serverName = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<Payment> getById(@PathVariable Long id) {
        String providerUrl = serverName + "/payments/";
        return restTemplate.getForObject(providerUrl + id, CommonResult.class);
    }

    @GetMapping("/discovery")
    @ResponseBody
    public CommonResult<DiscoveryClient> discovery() {

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:{}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instanceId={}",instance.getInstanceId());
            log.info("serviceId={}", instance.getServiceId());
            log.info(instance.toString());
        }
        return new CommonResult<DiscoveryClient>(200,"success",discoveryClient);
    }
}
