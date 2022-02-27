package com.cxw.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String testA() throws InterruptedException {
        Thread.sleep(1000);
        return "testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "testB";
    }


    @GetMapping("/hot")
    @SentinelResource(value = "hot",blockHandler = "hotKeyFallback")
    public String hotKey(String a, String b) {
        return "hot key!! a="+a+" b="+b;
    }

    public String hotKeyFallback(String a, String b, BlockException e) {
        return "fallback a:"+a+" ---b:"+b;
    }
}
