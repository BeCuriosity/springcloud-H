package com.cxw.springcloud;

import com.cxw.springcloud.config.MyRuleStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName OrderApplication8000
 * @Author xuwen_chen
 * @Date 2022-02-17 23:08
 * @Version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRuleStrategy.class)
public class OrderApplication8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication8000.class, args);
    }
}
