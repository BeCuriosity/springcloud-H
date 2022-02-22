package com.cxw.springcloud.controller;

import com.cxw.springcloud.entity.CommonResult;
import com.cxw.springcloud.entity.Payment;
import com.cxw.springcloud.service.PaymentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

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

    @Value("${server.port}")
    private String serverPort;

    @SneakyThrows
    @GetMapping("/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        Thread.sleep(3000);
        Payment byId = paymentService.getById(id);
        return new CommonResult<>(200, "success from server: payment"+serverPort, byId);
    }

    @SneakyThrows
    @GetMapping("/ok/{id}")
    public CommonResult<String> ok(@PathVariable("id") Long id) {
        String ok = paymentService.isOk(id);
        return new CommonResult<>(200, "success from server: payment"+serverPort, ok);
    }

    @SneakyThrows
    @GetMapping("/notOk/{id}")
    public CommonResult<String> notOk(@PathVariable("id") Long id) {
        String notOk = paymentService.isNotOK(id);
        DispatcherServlet servlet;
        return new CommonResult<>(200, "success from server: payment"+serverPort, notOk);
    }

    @SneakyThrows
    @GetMapping("/test1/{id}")
    public String t1(@PathVariable("id") Long id) {
        return "test1" + id;
    }

    @SneakyThrows
    @GetMapping("/test2/{id}")
    public String t2(@PathVariable("id") Long id) {
        return "test2" + id;
    }


}
