package com.cxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @ClassName com.cxw.NacosConfigApplication3377
 * @Author xuwen_chen
 * @Date 2022-02-26 20:54
 * @Version 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigApplication3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication3377.class, args);
    }
}
