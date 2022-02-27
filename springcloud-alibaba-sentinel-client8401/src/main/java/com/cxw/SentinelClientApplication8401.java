package com.cxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName SentinelClientApplication8401
 * @Author xuwen_chen
 * @Date 2022-02-27 22:38
 * @Version 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelClientApplication8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelClientApplication8401.class, args);
    }
}
