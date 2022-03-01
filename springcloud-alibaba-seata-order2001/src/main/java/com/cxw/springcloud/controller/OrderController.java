package com.cxw.springcloud.controller;

import com.cxw.springcloud.entity.Order;
import com.cxw.springcloud.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Author xuwen_chen
 * @Date 2022-03-01 23:38
 * @Version 1.0
 */

@RestController
public class OrderController {

    @Resource
    OrderService orderService;

    @GetMapping("/order/create")
    public String create(Order order) {
        orderService.create(order);
        return "订单创建成功！！！！";
    }

}
