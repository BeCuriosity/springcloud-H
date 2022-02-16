package com.cxw.springcloud.controller;

import com.cxw.springcloud.entity.CommonResult;
import com.cxw.springcloud.entity.Payment;
import com.cxw.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PaymentController
 * @Author xuwen_chen
 * @Date 2022-02-17 1:34
 * @Version 1.0
 */

@RestController
@RequestMapping("payments")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        Payment byId = paymentService.getById(id);
        return new CommonResult<>(200, "success", byId);
    }
}
