package com.cxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName NacosProviderApplication9001
 * @Author xuwen_chen
 * @Date 2022-02-26 18:38
 * @Version 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication9002.class, args);
    }

    @RestController
    public static class EchoController {
        @GetMapping(value = "/echo/{string}")
        public String echo(@PathVariable String string) {
            return "Hello Nacos Discovery9002 " + string;
        }
    }
}
