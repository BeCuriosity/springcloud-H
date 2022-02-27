package com.cxw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RibbonController
 * @Author xuwen_chen
 * @Date 2022-02-26 19:14
 * @Version 1.0
 */

@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("/test/{str}")
    public String echoAppName(@PathVariable("str") String str){
        return restTemplate.getForObject(serviceUrl + "/echo/" + str, String.class);
    }
}
