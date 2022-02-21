package com.cxw.controller;

import com.cxw.service.FeignHystrixServiceClient;
import com.cxw.springcloud.entity.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
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
}
