package com.cxw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName OrderApplication8000
 * @Author xuwen_chen
 * @Date 2022-02-17 23:08
 * @Version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class OrderApplication8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication8000.class, args);
    }
}