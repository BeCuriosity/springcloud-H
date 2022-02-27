package com.cxw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FlowLimiterController
 * @Author xuwen_chen
 * @Date 2022-02-27 22:39
 * @Version 1.0
 */

@RestController
public class FlowLimiterController {

    @GetMapping("/testA")
    public String testA() {
        return "testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "testB";
    }

}
