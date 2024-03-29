package com.cxw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName NacosClientController
 * @Author xuwen_chen
 * @Date 2022-02-26 21:01
 * @Version 1.0
 */

@RestController
@RefreshScope
public class NacosClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

}
