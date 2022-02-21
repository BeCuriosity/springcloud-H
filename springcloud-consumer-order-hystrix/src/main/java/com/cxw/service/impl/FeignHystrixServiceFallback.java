package com.cxw.service.impl;

import com.cxw.service.FeignHystrixServiceClient;
import com.cxw.springcloud.entity.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @ClassName FeignServiceFallback
 * @Author xuwen_chen
 * @Date 2022-02-21 21:55
 * @Version 1.0
 */

@Component
public class FeignHystrixServiceFallback implements FeignHystrixServiceClient {
    @Override
    public CommonResult<String> ok(Long id) {
        return new CommonResult<>(200, "8000 feign调用失败，降级处理");
    }

    @Override
    public CommonResult<String> notOk(Long id) {
        return new CommonResult<>(200, "8000 feign调用失败，降级处理");
    }
}
