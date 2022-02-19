package com.cxw.springcloud.controller;

import com.cxw.springcloud.entity.CommonResult;
import com.cxw.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName PaymentController
 * @Author xuwen_chen
 * @Date 2022-02-17 1:34
 * @Version 1.0
 */

@RestController
@RequestMapping("payments")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        return new CommonResult<>(200, "success from server: payment-from-zk"+serverPort, null);
    }
}
