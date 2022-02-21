package com.cxw.controller;

import com.cxw.service.FeignHystrixServiceClient;
import com.cxw.springcloud.entity.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName HystrixController
 * @Author xuwen_chen
 * @Date 2022-02-20 23:36
 * @Version 1.0
 */

@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "globalFallback")
public class HystrixController {

    @Resource
    private FeignHystrixServiceClient feignServiceClient;

    @GetMapping("ok/{id}")
    @ResponseBody
    public CommonResult<String> ok(@PathVariable Long id) throws InterruptedException {
        Thread.sleep(6000);
        return feignServiceClient.ok(id);
    }

    @GetMapping("notOk/{id}")
    @ResponseBody
//    @HystrixCommand(fallbackMethod = "notOkHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })
    public CommonResult<String> notOk(@PathVariable Long id) {
        return feignServiceClient.notOk(id);
    }

    public CommonResult<String> notOkHandler(@PathVariable Long id) {
        return new CommonResult<String>(500, "8000 hystrix fallback", null);
    }

    public CommonResult<String> globalFallback() {
        return new CommonResult<String>(500, "8000 hystrix global fallback", null);
    }

    @GetMapping("cir/{id}")
    @HystrixCommand(fallbackMethod = "circuitFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//打开开关
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//熔断10s后进入半打开状态
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求线程数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后熔断
    })
    public String circuit(@PathVariable("id") Long id) {
        //HystrixCommandProperties
        if(id < 0) {
            throw new RuntimeException();
        }
        return "success";
    }

    public String circuitFallback(@PathVariable("id") Long id){
        return "熔断保护";
    }
}
